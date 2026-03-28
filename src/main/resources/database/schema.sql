DROP DATABASE IF EXISTS homework003_db;

CREATE DATABASE homework003_db;

DROP TABLE IF EXISTS venues;
CREATE TABLE venues(
    venue_id SERIAL PRIMARY KEY,
    venue_name varchar(100) NOT NULL ,
    location varchar(255) NOT NULL
);

DROP TABLE IF EXISTS events;
CREATE TABLE events(
    event_id SERIAL PRIMARY KEY,
    event_name varchar(100) NOT NULL ,
    event_date DATE NOT NULL ,
    venue_id int4 ,
    FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
);

DROP TABLE IF EXISTS attendees;
CREATE TABLE attendees(
    attendee_id SERIAL PRIMARY KEY,
    attendee_name varchar(100) NOT NULL ,
    email TEXT NOT NULL
);

DROP TABLE IF EXISTS event_attendee;
CREATE TABLE event_attendee(
    attendee_id int4,
    event_id int4,
    FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id)
                           ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (event_id) REFERENCES events(event_id)
                           ON DELETE CASCADE ON UPDATE CASCADE
);



