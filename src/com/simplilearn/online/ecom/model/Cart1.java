package com.simplilearn.online.ecom.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="e_cart1")
public class Cart1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="cart_total")
	private double total;
	
	@ManyToMany(targetEntity=Product1.class, cascade = { CascadeType.ALL} )
	@JoinTable(name="ecart_eproduct", 
	joinColumns= {@JoinColumn(name="cart_id")},
	inverseJoinColumns= {@JoinColumn(name="product_id")})
	private Set<Product1> products;
	
	// 
	public Cart1(){}

	public Cart1(int cartId, double total, Set<Product1> products) {
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

	public Set<Product1> getProducts() {
		return products;
	}

	public void setProducts(Set<Product1> products) {
		this.products = products;
	}
	
}
