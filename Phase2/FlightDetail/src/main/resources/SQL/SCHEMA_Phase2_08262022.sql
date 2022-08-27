
drop table if exists address ;
drop TABLE if exists booking ;
drop table if exists booking_states ;
drop table if exists customer ;
drop table if exists users ;
drop table if exists user_types ;
drop table if exists flight_detail ;
drop table if exists airline ;
drop table if exists city ;
DROP VIEW IF EXISTS VIEW_FDETAILS ;

create table user_types
(
    ID bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_type varchar(128) UNIQUE NOT NULL
) ;
INSERT INTO user_types (user_type) VALUES ('CUSTOMER') ;
INSERT INTO user_types (user_type) VALUES ('ADMIN') ;
create table users
(
    ID	bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    user_name varchar(128) UNIQUE NOT NULL,
    user_pass varchar(128) NOT NULL,
    user_type varchar(128) NOT NULL,
    constraint USER_TYPE_CHECK check (user_type in ( select user_type from user_types))
) ;
create table customer
(
    ID	bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name	varchar(128) ,
    last_name	varchar(128) ,
    phone_number	varchar(128),
    email_address	varchaR(128),
    user_id		bigint(20) NOT NULL ,
    FOREIGN KEY (user_id) REFERENCES users ( ID ) ON DELETE CASCADE
) ;
create table address
(
    ID	bigint(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    customer_id bigint(20) NOT NULL,
    street_1	varchar(128) ,
    street_2	varchar(128),
    city		varchar(128),
    state		varchar(128),
    zipcode		varchar(128),
    FOREIGN KEY (customer_id ) REFERENCES customer( ID ) ON DELETE CASCADE
) ;
INSERT INTO users (user_name, user_pass, user_type)
VALUES ('joe.user@joes.com', 'joespassword', 'CUSTOMER') ;
INSERT INTO users (user_name, user_pass, user_type)
VALUES ('Admin@flyaway.com', 'Admin' , 'ADMIN' ) ;

INSERT INTO customer
(first_name, last_name, phone_number, email_address, user_id )
VALUES
    ('joes first name','joes last name','1-563-5637','joejoe@joes.com',
     (select ID from users where user_name='joe.user@joes.com') ) ;


INSERT INTO address ( street_1, street_2, city, state, zipcode, customer_id )
VALUES ('1234 joe street','','joe city','NJ','86543',
        (select customer.ID from customer
         where customer.user_id =
               (select distinct users.ID from users where users.user_name='joe.user@joes.com'))) ;


create table airline
(
    ID  			bigint(10)  	NOT NULL AUTO_INCREMENT PRIMARY KEY,
    airline_name 	varchar(20) 	NOT NULL,
    ticket_price 	decimal(10,2) 	NOT NULL
) ;

INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'Major Airline', 1200.00 ) ;
INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'XYZ', 200.00) ;
INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'ABC', 600.00 ) ;


create table city
(
    ID    bigint(20) NOT NULL AUTO_INCREMENT,
    city_name  varchar(20) NOT NULL,
    PRIMARY KEY( `ID` )
) ;
INSERT INTO city (city_name) VALUES ( 'New York') ;
INSERT INTO city (city_name) VALUES ( 'Los Angeles') ;
INSERT INTO city (city_name) VALUES ( 'Chicago') ;
INSERT INTO city (city_name) VALUES ( 'Dallas') ;
INSERT INTO city (city_name) VALUES ( 'Moscow') ;
INSERT INTO city (city_name) VALUES ( 'London') ;
INSERT INTO city (city_name) VALUES ( 'Helsinki') ;
INSERT INTO city (city_name) VALUES ( 'Cairo') ;

create table flight_detail
(
    ID  bigint(20)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    departure_cityID    bigint(20) NOT NULL,
    arrival_cityID      bigint(20) NOT NULL,
    airlineID           bigint(20) NOT NULL,
    travel_date         VARCHAR(30) NOT NULL,
    available_seats     integer(20) NOT NULL,
    FOREIGN KEY( departure_cityID )     REFERENCES city( ID ),
    FOREIGN KEY( arrival_cityID )       REFERENCES city( ID ),
    FOREIGN KEY( airlineID )            REFERENCES airline( ID )
) ;

INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Los Angeles'),
         (select ID from city where city_name = 'New York' ),
         (select ID from airline where airline_name = 'ABC'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Cairo'),
         (select ID from city where city_name = 'Los Angeles' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='London'),
         (select ID from city where city_name = 'Moscow' ),
         (select ID from airline where airline_name = 'Major Airline'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Dallas'),
         (select ID from city where city_name = 'Chicago' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Chicago'),
         (select ID from city where city_name = 'New York' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
         
CREATE VIEW VIEW_FDETAILS as
SELECT
    fd.ID, dc.city_name as departure_city,
    ac.city_name as arrival_city,
    a.airline_name as airline,
    fd.available_seats,
    fd.travel_date,
    a.ticket_price as ticket_price
FROM    flight_detail as fd,
        city as dc, city as ac, airline as a
WHERE   fd.departure_cityID = dc.ID
  AND   fd.arrival_cityID = ac.ID
  AND   fd.airlineID = a.ID ;


CREATE TABLE booking_states
(
    ID 	bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    booking_state	VARCHAR(40) NOT NULL
) ;

INSERT INTO booking_states (booking_state)
VALUES

    ('BOOKING_STATUS_RECORDCREATED'),
    ('BOOKING_STATUS_RESERVED'),
    ('BOOKING_STATUS_CANCELLED'),
    ('BOOKING_STATUS_TIMEDOUT'),
    ('BOOKING_STATUS_PAYMENTPENDING'),
    ('BOOKING_STATUS_PAYMENTAUTHORIZED'),
    ('BOOKING_STATUS_BOOKEDFINAL') ;



CREATE TABLE booking
(
    ID	bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    creation_time	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    statechange_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    booking_status	VARCHAR(40) NOT NULL DEFAULT 'BOOKING_STATUS_RECORDCREATED',
    customer_id		bigint(20)  NOT NULL,
    flight_detail_id bigint(20) ,
    seats_reserved	int	NOT NULL,
    total_price		double(10,2) NOT NULL ,
    FOREIGN KEY (customer_id) REFERENCES customer( ID ) ON DELETE CASCADE ,
    FOREIGN KEY (flight_detail_id) REFERENCES flight_detail( ID ) ON DELETE CASCADE ,
    constraint BOOKING_STATUS_CHECK check (boooking_status in ( select booking_state from booking_states))
) ;

