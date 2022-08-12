
DROP TABLE IF EXISTS 'employee_certificate' ;
create table 'employee_certificate' (
    'ID'	bigint(20) NOT NULL AUTO_INCREMENT,
    'description'	varchar(10) DEFAULT NULL,
    'employee_id'	bigint(20) NOT NULL,
    PRIMARY KEY ('ID')) ;