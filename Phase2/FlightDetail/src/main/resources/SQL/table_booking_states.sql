drop table booking_states ;
CREATE TABLE booking_states
(
    ID 	bigint(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    booking_state	VARCHAR(40) NOT NULL
) ;

INSERT INTO booking_states (booking_state)
VALUES

    ('BOOKING_STATUS_RECORDCREATED'),
    ('BOOKING_STATUS_RESERVED'),
    ('BOOKING_STATUS_CANCELLED'),
    ('BOOKING_STATUS_TIMEDOUT'),
    ('BOOKING_STATUS_PAYMENTPENDING'),
    ('BOOKING_STATUS_PAYMENTAUTHORIZED'),
    ('BOOKING_STATUS_BOOKEDFINAL') ;