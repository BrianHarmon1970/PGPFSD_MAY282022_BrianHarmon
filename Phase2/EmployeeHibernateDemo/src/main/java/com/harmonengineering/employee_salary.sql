DROP TABLE IF EXISTS 'employee_salary' ;
CREATE TABLE 'employee_salary' (
                                   `ID` 			bigint(20) NOT NULL AUTO_INCREMENT,
                                   `first_name`	          varchar(20) DEFAULT NULL,
                                   `last_name`		          varchar(20) DEFAULT NULL,
                                   `salary`		       decimal(10,2) DEFAULT NULL,
                                   PRIMARY KEY ( `ID`)) ;
