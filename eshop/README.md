# eshop
```
drop database if exists eshop;
CREATE database eshop;
USE eshop;

```

CREATE USER 'eshop'@'localhost'IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON *.* TO 'eshop'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;

```
LOAD DATA INFILE '/Users/macbook_1/libsprac/PAF/eshop/database/data.csv' 
INTO TABLE customers;
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 0 ROWS;
```

# tables


USE eshop;

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

create table order_status (

	order_id varchar(32) not null, 
	delivery_id varchar(128) not null,
    status varchar(128) not null,
    status_update TIMESTAMP not null
);

show tables;

select * from order_status;


```
