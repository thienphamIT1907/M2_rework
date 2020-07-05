package com.controllers;

import com.models.KhachHangModels.KhachHang;
import com.models.KhachHangModels.LoaiKhachHang;
import com.services.KhachHang.KhachHangService;
import com.services.KhachHang.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/khach-hang")
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    LoaiKhachHangService loaiKhachHangService;

    @ModelAttribute("listLoaiKhachHang")
    public Iterable<LoaiKhachHang> showListLoaiKhachHang() {
        return loaiKhachHangService.findAll();
    }

    @GetMapping("/danh-sach")
    public String xemDanhSachKhachHang(
            @PageableDefault(size = 8) Pageable pageable,
            @RequestParam Optional<String> keyword,
            Model model
    ) {
        Page<KhachHang> khachHangPage;
        if (keyword.isPresent()) {
            khachHangPage = khachHangService.findAllByHoTenContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        } else {
            khachHangPage = khachHangService.findAllPaging(pageable);
        }
        model.addAttribute("listKhachHang", khachHangPage);
        return "/khach-hang/danh-sach";
    }

    @GetMapping("/them")
    public ModelAndView showThemMoi() {
        return new ModelAndView("/khach-hang/them", "khachHang", new KhachHang());
    }

    @PostMapping("/them")
    public String themMoiKhachHang(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute KhachHang khachHang,
            BindingResult bindingResult
    ) {
        new KhachHang().validate(khachHang, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "khach-hang/them";
        } else {
            khachHangService.them(khachHang);
            redirectAttributes.addFlashAttribute("message", "Tạo mới khách hàng thành công !");
            return "redirect:/khach-hang/danh-sach";
        }
    }

    @GetMapping("/sua")
    public ModelAndView suaKhachHang(@RequestParam Long id) {
        return new ModelAndView("/khach-hang/sua", "khachHangSua", khachHangService.timTheoId(id));
    }

    @PostMapping("/sua")
    public String capNhatKhachHang(@ModelAttribute KhachHang khachHangDaCapNhat, RedirectAttributes redirectAttributes) {
        khachHangService.them(khachHangDaCapNhat);
        redirectAttributes.addFlashAttribute("message", "Cập nhật khách hàng thành công !");
        return "redirect:/khach-hang/danh-sach";
    }

    @GetMapping("/xoa")
    public String xoaKhachHang(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        khachHangService.xoaTheoId(id);
        redirectAttributes.addFlashAttribute("message", "Xoá khách hàng thành công !");
        return "redirect:/khach-hang/danh-sach";
    }
}
