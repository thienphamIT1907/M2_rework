package services;

import models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private final static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", "Description Iphone", "250.000"));
        products.put(2, new Product(2, "Samsung", "Description Samsung", "650.000"));
        products.put(3, new Product(3, "Xiaomi", "Description Xiaomi", "850.000"));
        products.put(4, new Product(4, "Nokia", "Description Nokia", "450.000"));
        products.put(5, new Product(5, "Huawei", "Description Huawei", "350.000"));
        products.put(6, new Product(6, "VSmart", "Description VSmart", "150.000"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
