package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

@Entity
public class SpecialFlightPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aircraftType;
    private String registrationNumber;
    private String flightItinerary;
    private String crewDetails;
    private String purposeOfFlight;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
}

