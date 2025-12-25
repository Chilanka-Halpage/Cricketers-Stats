CREATE TABLE country (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE player (
                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        country_id INT,
                        CONSTRAINT fk_country_id FOREIGN KEY (country_id) REFERENCES country (id)
);

INSERT
INTO
    country (name)
values ("Sri Lanka"),
       ("India"),
       ("Australia"),
       ("South Africa"),
       ("England"),
       ("Pakistan"),
       ("New Zealand"),
       ("Bangladesh");