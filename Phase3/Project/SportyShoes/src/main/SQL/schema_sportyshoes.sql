drop table if exists order_items ;
drop table if exists orders ;
drop table if exists user_cart ;

drop table if exists categories ;
create table categories
(
    ID 				bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    description		VARCHAR(64) NOT NULL
) ;
INSERT INTO categories (description) VALUES ('Mens'),('Womens') ;

drop table if exists user_types ;
create table user_types
(
    ID			BIGINT(20) 		PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_type	VARCHAR(64) 	UNIQUE KEY NOT NULL
) ;
INSERT INTO user_types ( user_type ) VALUES ( 'ADMIN' ) ;
INSERT INTO user_types ( user_type ) VALUES ( 'CUSTOMER' ) ;
INSERT INTO user_types ( user_type ) VALUES ( 'USER' ) ;

drop table if exists users ;
create table users
(
    ID 			BIGINT(20) 		PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_name	VARCHAR(128) 	UNIQUE KEY NOT NULL,
    user_pass	VARCHAR(128)	NOT NULL DEFAULT 'DEFAULT_PASS',
    user_type	VARCHAR(24)		NOT NULL DEFAULT 'USER',
    first_name	VARCHAR(128),
    last_name	VARCHAR(128),
    email		VARCHAR(128),
    phone_number VARCHAR(64),
    CONSTRAINT CHECK ( user_type IN (select user_type from user_types))
) ;
INSERT INTO users
(user_name, user_pass, user_type)
VALUES
    ( 'Admin@SportyShoes.com', 'Admin', 'ADMIN') ;

INSERT INTO users ( user_name, user_pass ) VALUES ( 'Joe.user@Joes.com','JoesPassword' ) ;
INSERT INTO users ( user_name, user_pass, first_name, last_name, email, phone_number )
VALUES
    ( 'Emporer1@byz.net', 'DEFAULT_PASS','Konstantine', 'Emperor', 'Emporer1@byz.net', '+9-999-999-9999' ),
    ( 'Bugz@wb.com', 'DEFAULT_PASS', 'Bugs', 'Bunny', 'whatsup@doc.net', '1-321-244-2666' ),
    ( 'Sam@wb.com', 'DEFAULT_PASS', 'Sam', 'Yosemite', 'varmintHunter@doublebarrel.net','349-435-2631' ),
    ( 'stevej@apple.com', 'DEFAULT_PASS', 'Steve', 'Jobbs', 'thebigguy@apple.com', '669-277-5311' ),
    ( 'stevew@apple.com', 'DEFAULT_PASS', 'Steve', 'Wozniak', 'thewozman@apple.com', '408-112-7753' ),
    ( 'alex@bell.com', 'DEFAULT_PASS', 'Alexander', 'Bell', 'AGBell@att.com', '1-111-111-1111' ),
    ( 'leo@inventorsrus.org', 'DEFAULT_PASS', 'Leonardo', 'Da Vinci', 'davinci@italy.telecom.net','1-234-554-3210' ) ;



drop table if exists product ;
create table product
(
    ID 				bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    description 	VARCHAR(256) NOT NULL,
    category		VARCHAR(64) NOT NULL,
    season          VARCHAR(64) ,
    brand           VARCHAR(64) ,
    color           VARCHAR(64) ,
    discount		DOUBLE( 3,2 ) DEFAULT 0.00 ,
    price 			DOUBLE( 10,2 ) NOT NULL,
    date_modified   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    date_added		TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    constraint check (category IN (select category from categories))
) ;
INSERT INTO product (category, description, price, date_added, season, brand, color, date_modified )
VALUES
    ('Womens','Classic Ultra Mini  ',139.95,'2022-09-27','Winter','UGG','Brown','2022-09-27'),
    ('Womens','Classic Short II',169.95,'2022-09-27','Winter','UGG','Brown','2022-09-27'),
    ('Womens','Classic All-Terrain Clog',54.95,'2022-09-27','Summer','Crocs','Black','2022-09-27'),
    ('Womens','Classic All-Terrain Clog',54.95,'2022-09-27','Summer','Crocs','White','2022-09-27'),
    ('Womens','Court Team Bounce',89.95,'2022-09-27','Summer','Adidas','Black','2022-09-27'),
    ('Womens','Tatianna Soft Spots',59.99,'2022-09-27','Summer','Comfortiva','White','2022-09-27'),
    ('Womens','Blanca T Strap',65.99,'2022-09-27','Summer','Rockport','White','2022-09-27'),
    ('Mens','Resorption Waterproof Composite Toe',114.95,'2022-09-27','Winter','Caterpillar','Black','2022-09-27'),
    ('Mens','Resorption Waterproof Composite Toe',114.95,'2022-09-27','Winter','Caterpillar','Brown','2022-09-28'),
    ('Mens','Court Team Bounce',89.95,'2022-09-28','Summer','Adidas','Black','2022-09-28'),
    ('Mens','Samba Classic',59.99,'2022-09-28','Summer','Adidas','Black','2022-09-28'),
    ('Mens','Davidson Grand Longwing Oxford',180.00,'2022-09-28','Summer','Cole Haan','Brown','2022-09-28'),
    ('Mens','Gryphon',129.95,'2022-09-28','Summer','Dr. Martens','Black','2022-09-28'),
    ('Mens','Rugged Bucks Waterproof Boot',140.00,'2022-09-28','Winter','Rockport','Brown','2022-09-28'),
    ('Mens','Rugged Flex 6 inch Waterproof Steel Toe',134.99,'2022-09-28','Winter','Carhartt','Brown','2022-09-28');


create table user_cart
(
    user_id		BIGINT(20) NOT NULL  REFERENCES  users(ID),
    product_id	BIGINT(20) NOT NULL REFERENCES product(ID),
    quantity	INTEGER	NOT NULL
) ;


create table orders
(
    ID			BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id		BIGINT(20) NOT NULL REFERENCES users(ID),
    order_date	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
) ;
create table order_items
(
    order_id	BIGINT(20) NOT NULL REFERENCES orders( ID ),
    product_id BIGINT(20) NOT NULL REFERENCES product( ID ),
    quantity	INTEGER NOT NULL,
    PRIMARY KEY ( product_id, order_id )
) ;


