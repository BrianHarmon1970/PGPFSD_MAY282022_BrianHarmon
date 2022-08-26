drop table flight_detail ;
create table flight_detail
(
    ID  bigint(20)      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    departure_cityID    bigint(20) NOT NULL,
    arrival_cityID      bigint(20) NOT NULL,
    airlineID           bigint(20) NOT NULL,
    travel_date         datetime NOT NULL,
    available_seats     integer(20) NOT NULL,
    FOREIGN KEY( departure_cityID )     REFERENCES city( ID ),
    FOREIGN KEY( arrival_cityID )       REFERENCES city( ID ),
    FOREIGN KEY( airlineID )            REFERENCES airline( ID )
) ;

INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Los Angeles'),
         (select ID from city where city_name = 'New York' ),
         (select ID from airline where airline_name = 'ABC'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Cairo'),
         (select ID from city where city_name = 'Los Angeles' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='London'),
         (select ID from city where city_name = 'Moscow' ),
         (select ID from airline where airline_name = 'Major Airline'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Dallas'),
         (select ID from city where city_name = 'Chicago' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
INSERT INTO flight_detail (departure_cityID, arrival_cityID, airlineID, travel_date, available_seats)
VALUES ( (select ID from city where city_name='Chicago'),
         (select ID from city where city_name = 'New York' ),
         (select ID from airline where airline_name = 'XYZ'),
         '11-02-2022', 20 ) ;
