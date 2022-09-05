drop table users ;
create table users
(
    ID	bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    user_name varchar(128) UNIQUE NOT NULL,
    user_pass varchar(128) NOT NULL,
    user_type varchar(128) NOT NULL,
    constraint USER_TYPE_CHECK check (user_type in ( select user_type from user_types))
) ;

INSERT INTO users (user_name, user_pass, user_type)
VALUES ('joe.user@joes.com', 'joespassword', 'CUSTOMER') ;
INSERT INTO users (user_name, user_pass, user_type)
VALUES ('Admin@flyaway.com', 'Admin' , 'ADMIN' ) ;
