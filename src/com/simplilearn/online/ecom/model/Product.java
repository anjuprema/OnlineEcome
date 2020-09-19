package com.simplilearn.online.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="e_product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_desc")
	private String description;
	
	@Column(name="product_price")
	private double price;
	
	@ManyToOne()
	@JoinColumn(name="cart_id" , nullable=false)
	private Cart cart;
	
	Product(){}

	public Product( String description, double price, Cart cart) {
		this.description = description;
		this.price = price;
		this.cart = cart;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
