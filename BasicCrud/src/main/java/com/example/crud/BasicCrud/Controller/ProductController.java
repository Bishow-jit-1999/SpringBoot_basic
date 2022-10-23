package com.example.crud.BasicCrud.Controller;

import com.example.crud.BasicCrud.Entity.Product;
import com.example.crud.BasicCrud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> AddProduct(@RequestBody Product product) {
        Product pro= null;
        try{
            pro = service.saveproduct(product);
            return ResponseEntity.of(Optional.of(pro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/addProducts")
    public List<Product> AddProducts(@RequestBody List<Product> products) {
        return service.saveproducts(products);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> GetAllProduct() {
        List<Product> product=service.getProducts();
        if( product.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(product)) ;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> GetAProduct(@PathVariable int id) {
        Product aproduct=service.getProduct(id);
        if(aproduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(aproduct));
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<Product> GetProductByname(@PathVariable String name) {
        Product Aproduct=service.getprouctbyname(name);
        if(Aproduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(Aproduct));
    }

    @GetMapping("/products/pricegreaterthan/{price}")
    public ResponseEntity<List<Product>> GetProductPriceWise(@PathVariable double price){
        List<Product>products=service.getProductPriceWise(price);
        if(products.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(products));
    }

    @GetMapping("product/max/price")
    public ResponseEntity<Product> MaxPriceProduct(){
        Product Aproduct= service.getHighPriceProduct();
        if(Aproduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(Aproduct));
    }

    @PutMapping("/product/update")
    public ResponseEntity<Product> UpdateProduct(@RequestBody Product product) {
        try{
            this.service.updateproduct(product);
            return ResponseEntity.ok().body(product);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Void> DeleteProduct(@PathVariable int id) {
        try{
            this.service.deleteproduct(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
}
