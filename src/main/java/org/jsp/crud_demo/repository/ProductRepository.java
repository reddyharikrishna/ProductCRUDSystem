package org.jsp.crud_demo.repository;

import java.util.List;

import org.jsp.crud_demo.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

}
