CREATE TABLE `eproduct` (
                            `ID` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) DEFAULT NULL,
                            `price` decimal(10,2) DEFAULT NULL,
                            `date_added` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
