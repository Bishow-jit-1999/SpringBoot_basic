package com.example.crud.BasicCrud.Service;

import com.example.crud.BasicCrud.Entity.Customer;
import com.example.crud.BasicCrud.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> saveCustomers(List<Customer>customerList){
        return customerRepository.saveAll(customerList);
    }

    public List<Customer> getallCustomer(){
        return customerRepository.findAll();
    }

    public Customer getcustomer(int id){
        return customerRepository.findById(id).orElse(null);
    }
}
