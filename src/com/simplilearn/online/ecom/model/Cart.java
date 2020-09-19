package com.simplilearn.online.ecom.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="e_cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="cart_total")
	private double total;
	
	@OneToMany(mappedBy="cart")
	private Set<Product> products;
	
	// 
	public Cart(){}

	public Cart(int cartId, double total, Set<Product> products) {
		super();
		this.cartId = cartId;
		this.total = total;
		this.products = products;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
