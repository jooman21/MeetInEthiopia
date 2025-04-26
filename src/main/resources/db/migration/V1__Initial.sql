

CREATE TYPE accessibility_needs AS ENUM ('wheelchair_access', 'sign_language_interpretation');

CREATE TYPE driver_requirements AS ENUM ('multilingual', 'security_trained');

CREATE TYPE emergency_contact AS ENUM ('EmergencyContactName', 'EmergencyContactRelationship', 'EmergencyContactPhone');

CREATE TYPE participant_category AS ENUM ('VIP', 'Delegate', 'Media');

CREATE TYPE position_title AS ENUM (
    'HEAD_OF_STATE',
    'HEAD_OF_GOVERNMENT',
    'VICE_PRESIDENT',
    'PRIME_MINISTER',
    'MINISTER',
    'DEPUTY_MINISTER',
    'AMBASSADOR',
    'PERMANENT_REPRESENTATIVE',
    'GOVERNOR',
    'MAYOR',
    'PARLIAMENT_MEMBER',
    'SENATOR',
    'DELEGATE',
    'CHIEF_OF_STAFF',
    'CHARGE_DAFFAIRES',
    'SECURITY_OFFICER',
    'MEDIA',
    'JOURNALIST',
    'PHOTOGRAPHER',
    'BROADCASTER',
    'NGO_REPRESENTATIVE',
    'ACADEMIC',
    'RESEARCHER',
    'ADVISOR',
    'CONSULTANT',
    'COMPANY_EXECUTIVE',
    'CEO',
    'CTO',
    'MANAGER',
    'INTERPRETER',
    'VOLUNTEER',
    'EVENT_STAFF',
    'SPONSOR_REPRESENTATIVE',
    'TECHNICIAN',
    'MEDICAL_PERSONNEL',
    'DIPLOMAT',
    'OBSERVER'
    );

CREATE TYPE preferred_hotel_type AS ENUM ('luxury', 'standard', 'budget');

CREATE TYPE special_requests AS ENUM ('connecting_rooms', 'security_requirements');

CREATE TYPE type_of_vehicle AS ENUM ('standard', 'chauffeured', 'armored');

CREATE TABLE participant (
                             id SERIAL PRIMARY KEY,
                             full_name VARCHAR(255),
                             position_title position_title, -- 🛠 use ENUM here
                             organization VARCHAR(255),
                             nationality VARCHAR(100),
                             passport_number VARCHAR(100),
                             email VARCHAR(255),
                             phone_number VARCHAR(50),
                             emergency_contact emergency_contact, -- 🛠 ENUM here
                             category participant_category, -- 🛠 ENUM here
                             dietary_restrictions VARCHAR(255),
                             accessibility_needs accessibility_needs -- 🛠 ENUM here
);

CREATE TABLE vehicle_rental (
                                id SERIAL PRIMARY KEY,
                                type_of_vehicle type_of_vehicle, -- 🛠 ENUM here
                                duration VARCHAR(255),
                                driver_requirements driver_requirements, -- 🛠 ENUM here
                                number_of_vehicles INT,
                                participant_id BIGINT UNIQUE,
                                CONSTRAINT fk_vehicle_rental_participant FOREIGN KEY (participant_id) REFERENCES participant(id)
);

CREATE TABLE accommodation (
                               id SERIAL PRIMARY KEY,
                               preferred_hotel_type preferred_hotel_type, -- 🛠 ENUM here
                               check_in DATE,
                               check_out DATE,
                               number_of_guests INT,
                               special_requests special_requests, -- 🛠 ENUM here
                               participant_id BIGINT UNIQUE,
                               CONSTRAINT fk_accommodation_participant FOREIGN KEY (participant_id) REFERENCES participant(id)
);
