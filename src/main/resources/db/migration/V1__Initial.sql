
CREATE TYPE accessibility_needs AS ENUM ('wheelchair_access', 'sign_language_interpretation', 'No_Need');
CREATE TYPE driver_requirements AS ENUM ('multilingual', 'security_trained');
CREATE TYPE participant_category AS ENUM ('VIP', 'Delegate', 'Media');
CREATE TYPE position_title AS ENUM (
    'HEAD_OF_STATE', 'HEAD_OF_GOVERNMENT', 'VICE_PRESIDENT', 'PRIME_MINISTER', 'MINISTER',
    'DEPUTY_MINISTER', 'AMBASSADOR', 'PERMANENT_REPRESENTATIVE', 'GOVERNOR', 'MAYOR',
    'PARLIAMENT_MEMBER', 'SENATOR', 'DELEGATE', 'CHIEF_OF_STAFF', 'CHARGE_DAFFAIRES',
    'SECURITY_OFFICER', 'MEDIA', 'JOURNALIST', 'PHOTOGRAPHER', 'BROADCASTER',
    'NGO_REPRESENTATIVE', 'ACADEMIC', 'RESEARCHER', 'ADVISOR', 'CONSULTANT', 'COMPANY_EXECUTIVE',
    'CEO', 'CTO', 'MANAGER', 'INTERPRETER', 'VOLUNTEER', 'EVENT_STAFF', 'SPONSOR_REPRESENTATIVE',
    'TECHNICIAN', 'MEDICAL_PERSONNEL', 'DIPLOMAT', 'OBSERVER'
    );
CREATE TYPE preferred_hotel_type AS ENUM ('luxury', 'standard', 'budget');
CREATE TYPE special_requests AS ENUM ('connecting_rooms', 'security_requirements');
CREATE TYPE type_of_vehicle AS ENUM ('standard', 'chauffeured', 'armored');

CREATE TABLE participant (
                             id UUID PRIMARY KEY NOT NULL,
                             full_name VARCHAR(255) NOT NULL,
                             position_title position_title NOT NULL,
                             organization VARCHAR(255) NOT NULL,
                             nationality VARCHAR(100) NOT NULL,
                             passport_number VARCHAR(100) NOT NULL,
                             email VARCHAR(255) NOT NULL,
                             phone_number VARCHAR(50) NOT NULL,
                             emergency_contact VARCHAR(255) NOT NULL,
                             category participant_category NOT NULL,
                             accessibility_needs accessibility_needs NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- =========================
-- Vehicle Rental Table
-- =========================
CREATE TABLE vehicle_rental (
                                id UUID PRIMARY KEY NOT NULL,
                                type_of_vehicle type_of_vehicle,
                                duration VARCHAR(255),
                                driver_requirements driver_requirements,
                                number_of_vehicles INT,
                                participant_id UUID,
                                CONSTRAINT fk_vehicle_rental_participant FOREIGN KEY (participant_id) REFERENCES participant(id),
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Accommodation Table
-- =========================
CREATE TABLE accommodation (
                               id UUID PRIMARY KEY NOT NULL,
                               preferred_hotel_type preferred_hotel_type,
                               check_in DATE,
                               check_out DATE,
                               number_of_guests INT,
                               special_requests special_requests,
                               participant_id UUID,
                               CONSTRAINT fk_accommodation_participant FOREIGN KEY (participant_id) REFERENCES participant(id),
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Customs Clearance Table
-- =========================
CREATE TABLE customs_clearance (
                                   id UUID PRIMARY KEY NOT NULL,
                                   item_description VARCHAR(255),
                                   quantity INT,
                                   purpose VARCHAR(255),
                                   dimensions_weight VARCHAR(255),
                                   import_type VARCHAR(255),
                                   supporting_documents VARCHAR(255),
                                   participant_id UUID,
                                   FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Event Accreditation Table
-- =========================
CREATE TABLE event_accreditation (
                                     id UUID PRIMARY KEY NOT NULL,
                                     participant_category VARCHAR(255),
                                     photo_id_url VARCHAR(255),
                                     affiliation VARCHAR(255),
                                     access_requirements VARCHAR(255),
                                     participant_id UUID,
                                     FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Itinerary Table
-- =========================
CREATE TABLE itinerary (
                           id UUID PRIMARY KEY NOT NULL,
                           pickup_location VARCHAR(255),
                           drop_off_location VARCHAR(255),
                           pickup_time TIMESTAMP,
                           drop_off_time TIMESTAMP,
                           vehicle_rental_id UUID,
                           FOREIGN KEY (vehicle_rental_id) REFERENCES vehicle_rental(id),
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Media Table
-- =========================
CREATE TABLE media (
                       id UUID PRIMARY KEY NOT NULL,
                       media_outlet VARCHAR(255),
                       media_type VARCHAR(255),
                       approved BOOLEAN,
                       accreditation_number VARCHAR(255),
                       access_areas VARCHAR(255),
                       participant_id UUID,
                       FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Media Equipment Clearance Table
-- =========================
CREATE TABLE media_equipment_clearance (
                                           id UUID PRIMARY KEY NOT NULL,
                                           equipment_list TEXT,
                                           serial_numbers TEXT,
                                           purpose_of_use TEXT,
                                           temporary_import_duration VARCHAR(255),
                                           storage_transport_plan TEXT,
                                           participant_id UUID,
                                           FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Post Event Activity Table
-- =========================
CREATE TABLE post_event_activity (
                                     id UUID PRIMARY KEY NOT NULL,
                                     preferred_activities VARCHAR(255),
                                     group_size INT,
                                     activity_dates VARCHAR(255),
                                     special_requests VARCHAR(255),
                                     participant_id UUID,
                                     FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- Radio Clearance Table
-- =========================
CREATE TABLE radio_clearance (
                                 id UUID PRIMARY KEY NOT NULL,
                                 device_types VARCHAR(255),
                                 frequency_bands VARCHAR(255),
                                 quantity_of_devices INT,
                                 usage_purpose VARCHAR(255),
                                 operator_details VARCHAR(255),
                                 participant_id UUID,
                                 FOREIGN KEY (participant_id) REFERENCES participant(id) ON DELETE CASCADE,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
