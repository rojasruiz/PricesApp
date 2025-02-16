create table brands (
    brand_id BIGINT not null,
    name VARCHAR(255) not null,
    PRIMARY KEY (brand_id)
);

create table prices (
    id BIGINT not null,
    brand_id BIGINT not null,
    start_date TimeStamp,
    end_date TimeStamp,
    price_list BIGINT not null,
    product_id BIGINT not null,
    priority Integer not null,
    price NUMERIC(15, 2) not null,
    currency CHAR(3) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);

INSERT INTO brands (brand_id, name)
VALUES (1, 'ZARA');

INSERT INTO
	prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES
	(1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO
	prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES
	(2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO
	prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES
	(3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO
	prices(id, brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES
	(4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');
