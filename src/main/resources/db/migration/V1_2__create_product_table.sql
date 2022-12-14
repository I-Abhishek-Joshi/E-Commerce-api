CREATE TABLE product(
    product_id INT generated by default as identity (start with 15) NOT NULL,
    product_name VARCHAR(200) NOT NULL,
    product_description VARCHAR(200) NOT NULL,
    product_feature VARCHAR(200) NOT NULL,
    product_price FLOAT NOT NULL,
    product_model_no VARCHAR(200) NOT NULL,
    product_quantity INT NOT NULL,
    PRIMARY KEY(product_id)
)