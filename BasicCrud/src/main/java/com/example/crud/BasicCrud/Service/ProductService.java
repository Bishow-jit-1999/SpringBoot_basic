package com.example.crud.BasicCrud.Service;

import com.example.crud.BasicCrud.Entity.Product;
import com.example.crud.BasicCrud.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //post method
    public Product saveproduct(Product product){

        return  repository.save(product);
    }
    public List<Product> saveproducts(List<Product> products){

        return repository.saveAll(products);
    }

    //get method
    public Product getProduct(int id){
        Product aproduct=null;
        try{
            aproduct =repository.findById(id).orElse(null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Product aproduct =repository.findById(id).orElse(null);
        return aproduct;

    }

    public  List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getprouctbyname(String name){
        Product aproduct=null;
        try{
            aproduct =repository.findByName(name);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return aproduct;
    }

    public List<Product> getProductPriceWise(double price) {

        return repository.productGreaterThanPrice(price);
    }

    public Product getHighPriceProduct(){
        return repository.getmaxpriceproduct();
    }


    //delete method

    public String deleteproduct(int id){
        repository.deleteById(id);
        return "Deleted product Id is"+id;
    }

    //update method

    public Product updateproduct(Product product){
        Product existingproduct=repository.findById(product.getId()).orElse(null);
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setQuantity(product.getQuantity());
        return repository.save(existingproduct);
    }



}
