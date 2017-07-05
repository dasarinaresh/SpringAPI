package org.naresh.spring.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.json.JSONObject;
import org.naresh.spring.model.Product;
import org.naresh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService prodService;
	
	@RequestMapping(value="/listall",method=RequestMethod.GET)
	public ResponseEntity<Object> listProducts(){
		List<Product> prodList = prodService.listAll();
		if(prodList !=null){
			return ResponseEntity.ok(prodList);
		}else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Products Found");
		}
	}
	
	@RequestMapping(value="/getproduct",method=RequestMethod.GET)
	public ResponseEntity<Object> getProduct(@RequestParam("id") int prodid){
		Product product = prodService.getById(prodid);
		if(product!=null){
			return ResponseEntity.ok(product);
		}else{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Products Found with Id " + prodid);
		}
	}
	
	@RequestMapping(value="/updateproduct/*",method=RequestMethod.PUT)
	public ResponseEntity<Object> saveProduct(@RequestBody String request){
		JSONObject reqObj = new JSONObject(request);
		int prodId = reqObj.getInt("prodid");
		String prodName = reqObj.getString("prodname");
		int prodQty = reqObj.getInt("prodqty");
		Product product = prodService.updateProduct(new Product(prodId, prodName, prodQty));
		
		if(product!=null){
			return ResponseEntity.ok(product);
		}else{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(request);
		}
	}
}
