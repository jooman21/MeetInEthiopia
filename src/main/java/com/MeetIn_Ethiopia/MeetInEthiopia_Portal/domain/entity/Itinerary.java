package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String pickupLocation;
    private String dropOffLocation;

    private LocalDateTime pickupTime;
    private LocalDateTime dropOffTime;

    @ManyToOne
    private VehicleRental vehicleRental; // or Participant, depending on your model
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

