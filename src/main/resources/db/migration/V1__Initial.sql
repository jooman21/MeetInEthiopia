

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
                             accessibility_needs accessibility_needs, -- 🛠 ENUM here
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE vehicle_rental (
                                id SERIAL PRIMARY KEY,
                                type_of_vehicle type_of_vehicle, -- 🛠 ENUM here
                                duration VARCHAR(255),
                                driver_requirements driver_requirements, -- 🛠 ENUM here
                                number_of_vehicles INT,
                                participant_id BIGINT UNIQUE,
                                CONSTRAINT fk_vehicle_rental_participant FOREIGN KEY (participant_id) REFERENCES participant(id),
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE accommodation (
                               id SERIAL PRIMARY KEY,
                               preferred_hotel_type preferred_hotel_type, -- 🛠 ENUM here
                               check_in DATE,
                               check_out DATE,
                               number_of_guests INT,
                               special_requests special_requests, -- 🛠 ENUM here
                               participant_id BIGINT UNIQUE,
                               CONSTRAINT fk_accommodation_participant FOREIGN KEY (participant_id) REFERENCES participant(id),
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Customs_Clearance
-- =========================
CREATE TABLE customs_clearance (
                                   id SERIAL PRIMARY KEY,
                                   item_description VARCHAR(255),
                                   quantity INT,
                                   purpose VARCHAR(255),
                                   dimensions_weight VARCHAR(255),
                                   import_type VARCHAR(255),
                                   supporting_documents VARCHAR(255),
                                   participant_id BIGINT UNIQUE,
                                   FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Event_Accreditation
-- =========================
CREATE TABLE event_accreditation (
                                     id SERIAL PRIMARY KEY,
                                     participant_category VARCHAR(255),
                                     photo_id_url VARCHAR(255),
                                     affiliation VARCHAR(255),
                                     access_requirements VARCHAR(255),
                                     participant_id BIGINT UNIQUE,
                                     FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Itinerary
-- =========================
CREATE TABLE itinerary (
                           id SERIAL PRIMARY KEY,
                           pickup_location VARCHAR(255),
                           drop_off_location VARCHAR(255),
                           pickup_time TIMESTAMP,
                           drop_off_time TIMESTAMP,
                           vehicle_rental_id BIGINT,
                           FOREIGN KEY (vehicle_rental_id) REFERENCES vehicle_rental(id),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP-- Assuming VehicleRental exists
);

-- =========================
-- Table: Media
-- =========================
CREATE TABLE media (
                       id SERIAL PRIMARY KEY,
                       media_outlet VARCHAR(255),
                       media_type VARCHAR(255),
                       approved BOOLEAN,
                       accreditation_number VARCHAR(255),
                       access_areas VARCHAR(255),
                       participant_id BIGINT UNIQUE,
                       FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Media_Equipment_Clearance
-- =========================
CREATE TABLE media_equipment_clearance (
                                           id SERIAL PRIMARY KEY,
                                           equipment_list TEXT,
                                           serial_numbers TEXT,
                                           purpose_of_use TEXT,
                                           temporary_import_duration VARCHAR(255),
                                           storage_transport_plan TEXT,
                                           participant_id BIGINT UNIQUE,
                                           FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Post_Event_Activity
-- =========================
CREATE TABLE post_event_activity (
                                     id SERIAL PRIMARY KEY,
                                     preferred_activities VARCHAR(255),
                                     group_size INT,
                                     activity_dates VARCHAR(255),
                                     special_requests VARCHAR(255),
                                     participant_id BIGINT UNIQUE,
                                     FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Table: Radio_Clearance
-- =========================
CREATE TABLE radio_clearance (
                                 id SERIAL PRIMARY KEY,
                                 device_types VARCHAR(255),
                                 frequency_bands VARCHAR(255),
                                 quantity_of_devices INT,
                                 usage_purpose VARCHAR(255),
                                 operator_details VARCHAR(255),
                                 participant_id BIGINT UNIQUE,
                                 FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

