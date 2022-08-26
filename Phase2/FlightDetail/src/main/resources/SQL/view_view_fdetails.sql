DROP VIEW VIEW_FDETAILS ;
CREATE VIEW VIEW_FDETAILS as
SELECT
        fd.ID, dc.city_name as departure_city,
        ac.city_name as arrival_city,
        a.airline_name as airline,
        fd.available_seats,
        fd.travel_date,
        a.ticket_price as ticket_price
FROM    flight_detail as fd,
        city as dc, city as ac, airline as a
WHERE   fd.departure_cityID = dc.ID
  AND   fd.arrival_cityID = ac.ID
  AND   fd.airlineID = a.ID ;


