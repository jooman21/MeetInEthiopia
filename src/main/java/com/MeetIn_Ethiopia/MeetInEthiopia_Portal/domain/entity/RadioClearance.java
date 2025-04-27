package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class RadioClearance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String deviceTypes;
    private String frequencyBands;
    private int quantityOfDevices;
    private String usagePurpose;
    private String operatorDetails;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
