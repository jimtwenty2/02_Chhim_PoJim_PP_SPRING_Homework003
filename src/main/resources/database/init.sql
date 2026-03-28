INSERT INTO venues (venue_name, location) VALUES
       ('Koh Pich Exhibition Center', 'Phnom Penh'),
       ('Sokha Siem Reap Resort', 'Siem Reap'),
       ('Morodok Techo Stadium', 'Phnom Penh'),
       ('Factory Phnom Penh', 'National Road 2'),
       ('The Heritage Walk', 'Siem Reap'),
       ('Raffles Hotel Le Royal', 'Daun Penh, PP'),
       ('Independence Beach Resort', 'Sihanoukville'),
       ('Aeon Mall Sen Sok Hall', 'Phnom Penh'),
       ('Brown Coffee Roastery', 'BKK1, Phnom Penh'),
       ('Rosewood Sky Bar', 'Vattanac Capital');


INSERT INTO events (event_name, event_date, venue_id) VALUES
       ('Cambodia Tech Expo', '2026-04-10', 1),
       ('Angkor Wat International Half Marathon', '2026-05-15', 2),
       ('SEA Games Anniversary', '2026-06-20', 3),
       ('Creative Design Workshop', '2026-07-05', 4),
       ('Startup Networking Night', '2026-08-12', 9),
       ('National Book Fair', '2026-09-22', 8),
       ('E-Sports Championship', '2026-10-30', 6),
       ('Real Estate Expo', '2026-11-15', 7),
       ('Khmer New Year Concert', '2026-12-25', 1),
       ('Youth Leadership Summit', '2027-01-10', 5);

INSERT INTO attendees (attendee_name, email) VALUES
       ('Sovan Chakriya', 'sovan.chakriya@gmail.com'),
       ('Chan Mony', 'chan.mony@hotmail.com'),
       ('Ly Dara', 'ly.dara@outlook.com'),
       ('Keo Sopheap', 'keo.sopheap@gmail.com'),
       ('Pich Thida', 'pich.thida@yahoo.com'),
       ('Heng Socheat', 'heng.socheat@gmail.com'),
       ('Mao Vicheka', 'mao.vicheka@gmail.com'),
       ('Nuon Sreyny', 'nuon.sreyny@gmail.com'),
       ('Oum Borin', 'oum.borin@gmail.com'),
       ('Sao Rothana', 'sao.rothana@gmail.com');

INSERT INTO event_attendee (attendee_id, event_id) VALUES
       (1, 1), (2, 1),
       (3, 1),
       (4, 2), (5, 2),
       (6, 3), (7, 3),
       (8, 4), (9, 4),
       (10, 4),
       (1, 5), (4, 5),
       (2, 6), (6, 6),
       (3, 7), (7, 7),
       (5, 8), (8, 8),
       (9, 9), (10, 9),
       (1, 10), (10, 10);

