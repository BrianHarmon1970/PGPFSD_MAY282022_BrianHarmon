DELIMITER $$
CREATE PROCEDURE add_product(IN pname varchar(100), IN pprice decimal(10,2))
INSERT INTO eproduct (name, price) VALUES (pname, pprice)
    $$
DELIMITER ;
