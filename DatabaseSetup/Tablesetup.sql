CREATE DATABASE INVENTORY_MANAGEMENT;
USE INVENTORY_MANAGEMENT;

CREATE TABLE INVENTORY(
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    inventory_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE PRODUCT (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    product_type VARCHAR(20)
);

CREATE TABLE PERISHABLE_PRODUCT (
    perishable_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    best_before INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);

CREATE TABLE NONPERISHABLE_PRODUCT (
    nonperishable_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    shelf_life INT NOT NULL, 
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);

CREATE TABLE STOCK_ALERT (
    alert_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    inventory_id INT NOT NULL,
    alert_type VARCHAR(20) DEFAULT 'LOW STOCK',
    alert_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'Active',
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id),
    FOREIGN KEY (inventory_id) REFERENCES INVENTORY(inventory_id)
);

CREATE TABLE STOCK_DATA (
    stock_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    inventory_id INT NOT NULL,
    stock_level INT DEFAULT 0,
    threshold INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id),
    FOREIGN KEY (inventory_id) REFERENCES INVENTORY(inventory_id)
);

CREATE TABLE TRANSACTION_LOG (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT NOT NULL,
    inventory_id INT NOT NULL,
    transaction_type VARCHAR(20),
    quantity INT NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id),
    FOREIGN KEY (inventory_id) REFERENCES INVENTORY(inventory_id)
);
