
USE eshop;

CREATE USER 'sherlock'@'localhost'IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'sherlock'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;

---

create table customers (

	name varchar(32) not null, 
	address varchar(128) not null,
    email varchar(128) not null
);

show tables;

select * from customers;

---

create table orders (
	orderId varchar(128) not null,
	deliveryId varchar(128) not null,
	name varchar(128) not null,
	address varchar(128) not null,
	email varchar(128) not null,
	status varchar(128) not null
    
);

show tables;

---
drop table if exists order_status;

create table order_status (

	order_id int(32) not null, 
	delivery_id varchar(128) not null,
    status varchar(128) not null
   
);

show tables;

select * from order_status;
---

LOAD DATA INFILE '/Users/macbook_1/libsprac/PAF/eshop/database/data.csv' INTO TABLE customers

---

select customer.name, order.order_id, order.delivery_id, OrderStatus.status as order_status
inner join order as ord
inner join order_id as oid
on customer = dispatchOrderStatus;