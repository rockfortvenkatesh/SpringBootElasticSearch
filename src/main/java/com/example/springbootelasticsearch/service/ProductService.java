package com.example.springbootelasticsearch.service;

import com.example.springbootelasticsearch.entity.Product;
import com.example.springbootelasticsearch.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public Product getById(int id){
        return productRepo.findById(id).get();
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public Product insert(Product product){
        return productRepo.save(product);
    }
    public Product update(int id, Product product) {
        Product OriginalProduct = productRepo.findById(id).get();
        OriginalProduct.setName((product.getName()));
        OriginalProduct.setPrice(product.getPrice());
        OriginalProduct.setDescription(product.getDescription());
        productRepo.save(OriginalProduct);
        return OriginalProduct;
    }
    public String delete(int id){
        Product Original_product = productRepo.findById(id).get();
        productRepo.delete(Original_product);
        return "Deleted Successfully";
    }
}
