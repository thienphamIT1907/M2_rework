package com.cart.controllers;

import com.cart.models.Cart;
import com.cart.models.Product;
import com.cart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("addToCart")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("addToCart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping("/")
    public ModelAndView showListProduct() {
        return new ModelAndView("list", "products", productService.findAll());
    }

//    @GetMapping("/add_product_to_cart/{id}")
//    public String addProductToCart(
//            @PathVariable Long id,
//            @SessionAttribute("addToCart") Cart cart,
//            Model model,
//            RedirectAttributes redirectAttributes
//    ) {
//        Product targetProduct = productService.findById(id);
//        Long amount = targetProduct.getAmount();
//        if (cart.contains(targetProduct)) {
//            targetProduct.setAmount(amount + 1);
//            model.addAttribute("products", targetProduct);
//        } else {
//            cart.add(productService.findById(id));
//        }
//        redirectAttributes.addFlashAttribute("status", "Add product to cart success !");
//        return "redirect:/";
//    }

    @GetMapping("/add_product_to_cart/{id}")
    public String getAdd(
            @SessionAttribute("addToCart") Cart cart,
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        Product productAddToCart = productService.findById(id);
        boolean isContain = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getIdProduct().equals(id)) {
                cart.get(i).setAmount(cart.get(i).getAmount() + 1);
                cart.get(i).setPrice(cart.get(i).getPrice() * cart.get(i).getAmount());
                cart.set(i, cart.get(i));
                isContain = true;
            }
        }
        if (isContain) {
            redirectAttributes.addFlashAttribute("status", "Add product exist to cart success !");
        } else {
            redirectAttributes.addFlashAttribute("status", "Add product to cart success !");
            cart.add(productAddToCart);
        }
        return "redirect:/";
    }


    @GetMapping("/remove_product_from_cart/{id}")
    public String getRemove(
            @SessionAttribute("addToCart") Cart cart,
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {
        for (Product item : cart) {
            if (item.getIdProduct().equals(id)) {
                cart.remove(item);
                break;
            }
        }
        redirectAttributes.addFlashAttribute("status", "Remove product from cart success !");
        return "redirect:/view_cart";
    }

    @GetMapping("/view_cart")
    public String viewCart(@SessionAttribute("addToCart") Cart cart, RedirectAttributes redirectAttributes, Model model) {
        if (cart.isEmpty()) {
            redirectAttributes.addFlashAttribute("status", "Your cart is empty !");
            return "redirect:/";
        } else {
            model.addAttribute("cart", cart);
            return "cart";
        }
    }
}
