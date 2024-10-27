package org.jsp.crud_demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(generator = "x")
	@SequenceGenerator(initialValue = 1001, allocationSize = 1, name = "x")
	private int id;
	private String name;
	private String details;
	private double price;
	private int discount;
}
