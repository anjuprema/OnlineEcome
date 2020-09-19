use onlineecomdb;

create table e_cart1 (
	cart_id int(11) NOT NULL AUTO_INCREMENT,
	cart_total decimal(10,0) NOT NULL,
	PRIMARY KEY (cart_id)
);

create table e_product1 (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	product_desc varchar(30) NOT NULL,
	product_price decimal(10,0),
	PRIMARY KEY (product_id)	
);

create table ecart_eproduct(
	cart_id int (11) NOT NULL,
	product_id int(11) NOT NULL,
	PRIMARY KEY (cart_id, product_id),
	CONSTRAINT cart_fk FOREIGN Key (cart_id) REFERENCES e_cart1 (cart_id),
	CONSTRAINT product_fk FOREIGN Key (product_id) REFERENCES e_product1 (product_id)
);