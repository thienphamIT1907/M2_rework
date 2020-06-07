package services;

import models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Xiaomi", "150.000", "des1"));
        products.put(2, new Product(2, "Huawei", "390.000", "des2"));
        products.put(3, new Product(3, "Iphone", "1.200.000", "des3"));
        products.put(4, new Product(4, "Nokia", "3.190.000", "des4"));
        products.put(5, new Product(5, "VSmart", "8.000.000", "des5"));
        products.put(6, new Product(6, "Samsung", "5.550.000", "des6"));
    }

    @Override
    public List<Product> findAll(){
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product){

        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id){
        return products.get(id);
    }

    @Override
    public void update(int id, Product product){
        products.put(id, product);

    }

    @Override
    public void remove(int id){
        products.remove(id);
    }
}
