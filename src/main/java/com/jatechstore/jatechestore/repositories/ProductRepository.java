package com.jatechstore.jatechestore.repositories;


import com.jatechstore.jatechestore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
