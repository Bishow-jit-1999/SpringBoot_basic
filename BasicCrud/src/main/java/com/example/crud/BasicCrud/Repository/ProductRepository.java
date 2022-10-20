package com.example.crud.BasicCrud.Repository;

import com.example.crud.BasicCrud.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

    @Query("select p from Product p where p.price>:pr")
    public List<Product> productGreaterThanPrice(@Param("pr") double pr);


}
