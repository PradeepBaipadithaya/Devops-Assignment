-- Check if the database exists
SELECT IF(EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'hospital'), 'Database exists', 'Database does not exist') AS db_check;

-- If the database does not exist, create it
CREATE DATABASE IF NOT EXISTS hospital;

USE hospital;

CREATE TABLE login (
    id VARCHAR(255),
    role VARCHAR(255),
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

-- Insert one admin login (manually added, with a known hashed password for testing)
-- Assuming your application uses bcrypt for password hashing
-- Example password: 'admin123' hashed with bcrypt
INSERT INTO login (id, role, username, password) VALUES ('EMP100', 'administrator', 'root123', '$2y$10$TKh8H1.Py5oM6uGm.A8GhuJL7Ht.j6F76XaO7W6JkPh7J4bqMEaD2');

INSERT INTO login (id, role, username, password) VALUES
    ('EMP101', 'doctor', 'EMP101', '$2a$10$We9z/qK7DoBK5eY7kSJ3Cud2Rb6VDMGKDBSnvXzfHQnW/Ds1zKdBi'),
    ('EMP103', 'doctor', 'EMP103', '$2a$10$RwTr3JDO1T64S.7C45J5yOQ4IlKLo8veU6NdBaqyff4FSbmarKLXC'),
    ('EMP104', 'administrator', 'EMP104', '$2a$10$LmE4x1jf6fvb/1fOp.6I.OTH7qzx..p9yjJjOovXGnHLsAh9VC02a'),
    ('EMP105', 'receptionist', 'EMP105', '$2a$10$uArJiQ3sFGGEWzmrJA4U/eDXBooIa0hg59PK4BADJo5iMSY1LPhoy');

CREATE TABLE employee (
    joiningDate DATE,
    eid VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    middleName VARCHAR(255),
    lastName VARCHAR(255),
    birthdate DATE,
    gender VARCHAR(255),
    emailID VARCHAR(255) UNIQUE,
    mobileno BIGINT UNIQUE,
    adharNo BIGINT UNIQUE,
    country VARCHAR(255),
    state VARCHAR(255),
    city VARCHAR(255),
    residentialAddress VARCHAR(255),
    permanentAddress VARCHAR(255),
    role VARCHAR(255),
    qualification VARCHAR(255),
    specialization VARCHAR(255),
    status INT
);

INSERT INTO employee VALUES
    ('2020-06-21', 'EMP101', 'neelima', 'arun', 'pawar', '1975-01-07', 'female', 'neelima@gmail.com', 9013456893, 143590034912, 'india', 'maharashtra', 'nashik', 'vandana apartment, nashik', 'vandana apartment, nashik', 'doctor', 'mbbs, md', 'gynacologist', 1),
    ('2020-06-21', 'EMP102', 'arun', 'nanaji', 'pawar', '1978-05-12', 'male', 'arun@gmail.com', 9800274565, 409285671923, 'india', 'maharashtra', 'nashik', 'kamod nagar', 'kamod nagar', 'doctor', 'mbbs', 'none', 0),
    ('2020-06-21', 'EMP103', 'jagannath', 'yadav', 'suryawanshi', '1990-03-07', 'male', 'jagannath@gmail.com', 9028823456, 103758492134, 'india', 'maharashtra', 'aurangabad', 'gajanan banglow nashik', 'rushika niwas', 'doctor', 'ms', 'surgery', 1),
    ('2020-06-21', 'EMP104', 'riddhi', 'arun', 'pawar', '1990-03-09', 'female', 'riddhi@gmail.com', 9567834245, 345600189345, 'india', 'maharashtra', 'pune', 'damodar heights', 'damodar heights', 'administrator', 'be', 'computer science', 1),
    ('2020-06-21', 'EMP105', 'neha', 'ravindra', 'kothawade', '1992-02-14', 'female', 'neha@gmail.com', 1234567890, 920385967123, 'india', 'maharashtra', 'nashik', 'narayani bunglow', 'narayani bunglow', 'receptionist', 'be', 'computer', 1);

CREATE TABLE patient (
    registrationDate DATE,
    pid VARCHAR(255) PRIMARY KEY,
    firstName VARCHAR(255),
    middleName VARCHAR(255),
    lastName VARCHAR(255),
    birthdate DATE,
    gender VARCHAR(255),
    emailID VARCHAR(255) UNIQUE,
    mobileno BIGINT UNIQUE,
    adharNo BIGINT UNIQUE,
    country VARCHAR(255),
    state VARCHAR(255),
    city VARCHAR(255),
    residentialAddress VARCHAR(255),
    permanentAddress VARCHAR(255),
    bloodGroup VARCHAR(5),
    chronicDiseases VARCHAR(255),
    medicineAllergy VARCHAR(255),
    doctorId VARCHAR(255),
    CONSTRAINT fk_assigned_doctorid FOREIGN KEY (doctorId) REFERENCES employee(eid)
);

INSERT INTO patient VALUES
    ('2020-06-21', 'P101', 'ashlesha', 'atul', 'narkhede', '1990-04-12', 'female', 'ashlesha@gmail.com', 1989478593, 901238756123, 'india', 'maharashtra', 'nashik', 'bhabha nagar', 'bhabha nagar', 'A+', 'none', 'bluemox', 'EMP101'),
    ('2020-06-21', 'P102', 'ritu', 'yuvraj', 'mahajan', '1990-05-02', 'female', 'ritu@gmail.com', 9823475901, 109478563215, 'india', 'maharashtra', 'nashik', 'uttam nagar', 'uttam nagar', 'B-', 'diabetes', 'none', 'EMP103'),
    ('2020-06-21', 'P103', 'siddhi', 'pramod', 'patil', '1991-05-17', 'female', 'siddhi@gmail.com', 9847382091, 823947610019, 'india', 'maharashtra', 'nashik', 'happy house apartment', 'happy house apartment', 'O+', 'none', 'none', 'EMP102'),
    ('2020-06-21', 'P104', 'kusum', 'pawan', 'hiray', '1973-06-28', 'female', 'kusum@gmail.com', 9478301834, 728001823453, 'india', 'maharashtra', 'nashik', 'panchavati, nashik', 'panchavati, nashik', 'AB+', 'diabetes', 'none', 'EMP101'),
    ('2021-12-06', 'P105', 'anand', 'nitin', 'shirole', '2000-08-10', 'male', 'anand123@gmail.com', 9023710243, 450123948572, 'india', 'maharashtra', 'pune', 'bibewadi', 'bibewadi', 'AB+', 'none', 'none', 'EMP101');

CREATE TABLE opd (
    opdid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    visitdate DATE,
    pid VARCHAR(255),
    doctorid VARCHAR(255),
    status INT NOT NULL,
    CONSTRAINT fk_pid FOREIGN KEY (pid) REFERENCES patient(pid),
    CONSTRAINT fk_doctorid FOREIGN KEY (doctorid) REFERENCES employee(eid)
);

INSERT INTO opd VALUES
    (1, '2020-06-10', 'P101', 'EMP101', 0),
    (7, '2020-06-21', 'P101', 'EMP101', 0),
    (11, '2021-12-05', 'P102', 'EMP103', 1),
    (13, '2021-12-05', 'P104', 'EMP101', 2),
    (14, '2021-12-06', 'P105', 'EMP101', 0);

CREATE TABLE opddetails (
    opdid INT,
    symptoms VARCHAR(255),
    diagnosis VARCHAR(255),
    medicinesDose VARCHAR(255),
    dos VARCHAR(255),
    donts VARCHAR(255),
    investigations VARCHAR(255),
    followupDate DATE,
    fees INT,
    CONSTRAINT fk_opdid FOREIGN KEY (opdid) REFERENCES opd(opdid) ON DELETE CASCADE
);

INSERT INTO opddetails VALUES
    (1, '#headache #bodypain', 'weakness', '#crocin@2 #neutrolin-B@3', '#drink warm water', '#junk food', 'none', '2020-06-20', 200),
    (13, '#high fever #nausea #headache #weakness', 'viral fever', '#crocin-500@2 #neutrolin-B@1', '#drink warm water', '#avoid fried or cool food item', 'none', '2021-12-16', 300),
    (14, '#weakness #nausea', 'fever', '#meftal spas@2', '#rest', '#cold food items', 'none', '2021-12-23', 700),
    (7, '#abdominal pain #fever #nausea', 'typhoid', '#crocin500@2 #meftal spas@2 #ofloxine500@1', '#rest #eat dal-chaval #warm water', '#oily food #cold drinks', 'blood test', '2020-06-26', 500);

CREATE TABLE idgenerate (
    eid INT NOT NULL PRIMARY KEY,
    pid INT NOT NULL UNIQUE
);

INSERT INTO idgenerate VALUES (5, 5);

DELIMITER //

CREATE PROCEDURE users_in_system(OUT doctors INT, OUT patients INT, OUT employees INT, OUT total_opd_income INT)
BEGIN
    SELECT COUNT(*) INTO doctors FROM employee WHERE role = 'doctor' AND status = 1;
    SELECT COUNT(*) INTO patients FROM patient;
    SELECT COUNT(*) INTO employees FROM employee WHERE status = 1;
    SELECT SUM(fees) INTO total_opd_income FROM opddetails;
END //

DELIMITER ;
