package org.naresh.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.naresh.spring.model.Product;
import org.naresh.spring.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public List<Product> listAll(){
		List<Product> prodList = new ArrayList<Product>();
		prodRepo.findAll().forEach(prodList::add);
		return prodList;	
	}

	@Override
	public Product getById(int id) {
		Product product = prodRepo.findOne(id);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		log.info(String.valueOf(product.getProd_id()));
		log.info(product.getProduct_name());
		log.info(String.valueOf(product.getProduct_qty()));
		
		prodRepo.save(product);
		return product;
	}
}
