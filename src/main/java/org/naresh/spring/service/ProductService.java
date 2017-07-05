package org.naresh.spring.service;

import java.util.List;

import org.naresh.spring.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

	List<Product> listAll();
	
	Product getById(int id);
	
	Product updateProduct(Product product);
	
}
