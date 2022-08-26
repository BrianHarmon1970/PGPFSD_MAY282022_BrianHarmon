drop table address ;
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

INSERT INTO address ( street_1, street_2, city, state, zipcode, customer_id )
VALUES ('1234 joe street','','joe city','NJ','86543',
        (select customer.ID from customer
            where customer.user_id =
                  (select distinct users.ID from users where users.user_name='joe.user@joes.com'))) ;
