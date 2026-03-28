SELECT * FROM venues;

SELECT * FROM attendees;

SELECT * FROM events;

SELECT * FROM venues WHERE venue_id = 120;

SELECT COUNT(*) > 0 FROM venues WHERE venue_id = 100;

DELETE FROM venues WHERE venue_id = 1 RETURNING *;

SELECT DISTINCT  e.venue_id FROM events e INNER JOIN public.venues v on v.venue_id = e.venue_id;

INSERT INTO venues (venue_name, location) VALUES
    ('Scam Center', 'Phnom Penh - HRD') RETURNING *;

SELECT * FROM venues;

SELECT COUNT(*) > 0 FROM attendees WHERE attendee_name = 'ji' AND attendee_id != 1;

UPDATE attendees SET attendee_name = 'null' WHERE attendee_id = 1 RETURNING *;

SELECT * FROM events;

SELECT * FROM events where venue_id = 1 ;

SELECT * FROM attendees a INNER JOIN event_attendee ea ON
    a.attendee_id = ea.attendee_id;

SELECT * FROM attendees a INNER JOIN event_attendee ea ON
    a.attendee_id = ea.attendee_id WHERE event_id = 17;

SELECT COUNT(*) > 0 FROM events WHERE event_name = 'Cambodia Tech Expo' AND event_date = '2026-04-10';

INSERT INTO events (event_name, event_date, venue_id)
VALUES ('#{req.eventName}', '2300-09-9', 1) returning *;

UPDATE events SET event_name = 'Hello' ,
    event_date = '2028-08-10',
    venue_id = 1
WHERE event_id = 1
    RETURNING *;

DELETE FROM event_attendee WHERE event_id = 1 AND attendee_id = 2 RETURNING *;

SELECT a.attendee_id from attendees a INNER JOIN event_attendee ea ON a.attendee_id = ea.attendee_id WHERE event_id = 4;