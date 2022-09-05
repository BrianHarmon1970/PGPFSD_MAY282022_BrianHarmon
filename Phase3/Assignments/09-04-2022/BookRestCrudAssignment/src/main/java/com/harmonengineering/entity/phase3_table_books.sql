DROP TABLE IF EXISTS books ;
CREATE TABLE books
(
   ID bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
   description varchar(255) DEFAULT NULL,
   published int(8) DEFAULT NULL,
   title varchar(255) DEFAULT NULL
) ;