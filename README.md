# Task_projectCrud
#plzz Follow this Step to make Responsive Application

CREATE DATABASE IF NOT EXISTS event_management;
USE event_management;

CREATE TABLE IF NOT EXISTS organizers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact_info VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS venues (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);


CREATE TABLE IF NOT EXISTS events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date DATE NOT NULL,
    description TEXT,
    organizer_id BIGINT,
    venue_id BIGINT,
    FOREIGN KEY (organizer_id) REFERENCES organizers(id),
    FOREIGN KEY (venue_id) REFERENCES venues(id)
);


-- Insert sample data into organizers
INSERT INTO organizers (name, contact_info) VALUES ('John Doe', 'john@example.com');
INSERT INTO organizers (name, contact_info) VALUES ('Jane Smith', 'jane@example.com');


-- Insert sample data into venues
INSERT INTO venues (name, location, capacity) VALUES ('Conference Center', '123 Main St', 500);
INSERT INTO venues (name, location, capacity) VALUES ('Community Hall', '456 Elm St', 200);


-- Insert sample data into events
INSERT INTO events (event_name, event_date, description, organizer_id, venue_id) 
VALUES ('Tech Conference 2024', '2024-05-20', 'Annual tech conference.', 1, 1);
INSERT INTO events (event_name, event_date, description, organizer_id, venue_id) 
VALUES ('Art Exhibition', '2024-06-15', 'Local art exhibition.', 2, 2);

