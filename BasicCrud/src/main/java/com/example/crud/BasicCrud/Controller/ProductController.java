package com.example.crud.BasicCrud.Controller;

import com.example.crud.BasicCrud.Entity.Product;
import com.example.crud.BasicCrud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product AddProduct(@RequestBody Product product) {
        return service.saveproduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> AddProducts(@RequestBody List<Product> products) {
        return service.saveproducts(products);
    }

    @GetMapping("/products")
    public List<Product> GetAllProduct() {
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product GetAProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @GetMapping("/product/name/{name}")
    public Product GetProductByname(@PathVariable String name) {
        return service.getprouctbyname(name);
    }

    @GetMapping("/products/pricegreaterthan/{price}")
    public List<Product> GetProductPriceWise(@PathVariable double price){
        return service.getProductPriceWise(price);
    }

    @PutMapping("/product/update")
    public Product UpdateProduct(@RequestBody Product product) {
        return service.updateproduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public String DeleteProduct(@PathVariable int id) {
        return service.deleteproduct(id);
    }
}
