package com.example.crud.BasicCrud.Repository;

import com.example.crud.BasicCrud.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {


}
