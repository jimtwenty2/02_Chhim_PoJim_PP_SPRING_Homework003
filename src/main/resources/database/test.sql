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