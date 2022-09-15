CREATE TABLE user_reg(
    user_id INT NOT NULL,
    username VARCHAR(200) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    customer_id INT NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
)