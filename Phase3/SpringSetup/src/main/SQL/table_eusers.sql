use ecommerce;
drop table if exists eusers ;
create table eusers
(
    ID	bigint(20)	PRIMARY KEY AUTO_INCREMENT NOT NULL,
    user_name	varchar(128) NOT NULL,
    first_name 	varchar(128) DEFAULT NULL,
    last_name	varchar(121) DEFAULT NULL
) ;
INSERT INTO EUSERS ( user_name, first_name, last_name) VALUES ( 'EUSER@one.com', 'NumberOne', 'User' ) ;
