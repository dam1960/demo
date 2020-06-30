DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
    id INT AUTO_INCREMENT primary key,
    first_name varchar(250),
    last_name varchar(250),
    email varchar(250)
);
