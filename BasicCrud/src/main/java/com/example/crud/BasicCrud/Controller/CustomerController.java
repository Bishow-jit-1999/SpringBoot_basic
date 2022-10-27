package com.example.crud.BasicCrud.Controller;

import com.example.crud.BasicCrud.Entity.Customer;
import com.example.crud.BasicCrud.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> addCustomer (@RequestBody Customer customer) {
        Customer cus= null;
        try{
            cus = customerService.saveCustomer(customer);
            return ResponseEntity.of(Optional.of(cus));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @PostMapping("/addCustomers")

    public ResponseEntity<List<Customer>>addCustomers (@RequestBody List<Customer>customerList){
        List<Customer>cuslist;
        try{
            cuslist=customerService.saveCustomers(customerList);
            return ResponseEntity.of(Optional.of(cuslist));

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getCustomer")

    public ResponseEntity<List<Customer>> getallCustomer(){
        List<Customer> cuslist=customerService.getallCustomer();
        if(cuslist.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(cuslist));
    }

    @GetMapping("/getCustomer/{id}")

    public ResponseEntity<Customer> getAcustomer(@PathVariable int id){
        Customer cus=customerService.getcustomer(id);
        if(cus==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(cus));
    }
}
