package org.jsp.crud_demo.controller;

import java.util.List;

import org.jsp.crud_demo.dto.Product;
import org.jsp.crud_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	ProductRepository repository;

	@GetMapping("/")
	public String loadMain(ModelMap map) {
		List<Product> products = repository.findAll();
		if (products.isEmpty()) {
			map.put("failure", "No Records Found");
			return "main.html";
		} else {
			map.put("list", products);
			return "main.html";
		}
	}

	@GetMapping("/insert")
	public String loadInsert(ModelMap map) {
		map.put("insert", "insert");
		return loadMain(map);
	}

	@PostMapping("/insert")
	public String insert(Product product, ModelMap map) {
		repository.save(product);
		map.put("success", "Record Saved Success");
		return loadMain(map);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Record deleted Success");
		return loadMain(map);
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, ModelMap map) {
		Product product = repository.findById(id).orElseThrow();
		map.put("product", product);
		map.put("update", "update");
		return loadMain(map);
	}

	@PostMapping("/update")
	public String update(Product product, ModelMap map) {
		repository.save(product);
		map.put("success", "Record Updated Success");
		return loadMain(map);
	}

	@GetMapping("/fetch")
	public String fetch(ModelMap map) {
		map.put("fetch", "fetch");
		return loadMain(map);
	}

	@GetMapping("/fetch/{field}")
	public String fetch(ModelMap map, @PathVariable String field) {
		map.put("field", field);
		return loadMain(map);
	}

	@PostMapping("/fetch/name")
	public String fetchByName(@RequestParam String name, ModelMap map) {
		List<Product> list = repository.findByName(name);
		if (list.isEmpty()) {
			map.put("failure", "No Records Found");
			return "main.html";
		} else {
			map.put("list", list);
			map.put("success", "Record Found");
			return "main.html";
		}
	}

}
