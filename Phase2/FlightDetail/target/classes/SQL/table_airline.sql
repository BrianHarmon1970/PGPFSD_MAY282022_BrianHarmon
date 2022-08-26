drop table airline ;
create table airline
(
    ID  			bigint(10)  	NOT NULL AUTO_INCREMENT PRIMARY KEY,
    airline_name 	varchar(20) 	NOT NULL,
    ticket_price 	decimal(10,2) 	NOT NULL
) ;

INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'Major Airline', 1200.00 ) ;
INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'XYZ', 200.00) ;
INSERT INTO airline (airline_name, ticket_price ) VALUES ( 'ABC', 600.00 ) ;
