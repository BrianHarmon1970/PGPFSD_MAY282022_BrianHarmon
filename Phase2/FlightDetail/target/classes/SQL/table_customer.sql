drop table customer ;
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


INSERT INTO customer
(first_name, last_name, phone_number, email_address, user_id )
VALUES
    ('joes first name','joes last name','1-563-5637','joejoe@joes.com',
     (select ID from users where user_name='joe.user@joes.com') ) ;

