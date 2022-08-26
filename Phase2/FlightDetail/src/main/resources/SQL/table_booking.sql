drop TABLE booking ;
CREATE TABLE booking
(
    ID	bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    creation_time	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    statechange_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    booking_status	VARCHAR(40) NOT NULL DEFAULT 'BOOKING_STATUS_RECORDCREATED',
    customer_id		bigint(20)  NOT NULL,
    flight_detail_id bigint(20) ,
    seats_reserved	int	NOT NULL,
    total_price		double(10,2) NOT NULL ,
    FOREIGN KEY (customer_id) REFERENCES customer( ID ) ON DELETE CASCADE ,
    FOREIGN KEY (flight_detail_id) REFERENCES flight_detail( ID ) ON DELETE CASCADE ,
    constraint BOOKING_STATUS_CHECK check (boooking_status in ( select booking_state from booking_states))
) ;
