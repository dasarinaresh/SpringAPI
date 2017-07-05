package org.naresh.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product  implements Serializable {

	private static final long serialVersionUID = 3334936998891555947L;
	
	@Id
	@Column(name="prod_id")
	private int prod_id;
	private String product_name;
	private int product_qty;
	
	public Product(){
		
	}
	public Product(int prod_id, String product_name, int product_qty) {
		this.prod_id = prod_id;
		this.product_name = product_name;
		this.product_qty = product_qty;
	}
	
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}

	
	
}
