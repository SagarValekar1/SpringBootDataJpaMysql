package com.app.runner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
@Override
public void run(String... args) throws Exception {
	repo.save(new Product(2,"AAA",34.5));
	repo.save(new Product("BBB",23.5));
	repo.save(new Product("ccc",55.5));
	// get one row
	Optional<Product> p=repo.findById(3);
	System.out.println(p);
	
	//get all records
	List<Product> list=repo.findAll();
	list.forEach(System.out::println);
	
	// delete row
	//repo.deleteById(2);
	
	//delete All rows
	//repo.deleteAll();
	repo.deleteAllInBatch();
}
}
