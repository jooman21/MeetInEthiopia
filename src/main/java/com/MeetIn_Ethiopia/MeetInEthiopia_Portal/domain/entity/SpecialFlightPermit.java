package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SpecialFlightPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String aircraftType;
    private String registrationNumber;
    private String flightItinerary;
    private String crewDetails;
    private String purposeOfFlight;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

