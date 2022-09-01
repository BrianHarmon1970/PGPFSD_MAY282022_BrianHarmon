drop table user_types ;
create table user_types
(
    ID bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_type varchar(128) UNIQUE NOT NULL
) ;
INSERT INTO user_types (user_type) VALUES ('CUSTOMER') ;
INSERT INTO user_types (user_type) VALUES ('ADMIN') ;
