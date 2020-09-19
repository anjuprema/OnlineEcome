use onlineecomdb;

create table e_cart (
	cart_id int(11) NOT NULL AUTO_INCREMENT,
	cart_total decimal(10,0) NOT NULL,
	PRIMARY KEY (cart_id)
);

create table e_product (
	product_id int(11) NOT NULL AUTO_INCREMENT,
	product_desc varchar(30) NOT NULL,
	product_price decimal(10,0),
	cart_id int(11) NOT NULL,
	PRIMARY KEY (product_id),
	KEY cart_fk (cart_id),
	CONSTRAINT product_cat_fk FOREIGN Key (cart_id) REFERENCES e_cart (cart_id)	
);