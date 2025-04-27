package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CustomsClearance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String itemDescription;
    private int quantity;
    private String purpose;
    private String dimensionsWeight;
    private String importType; // temporary or permanent
    private String supportingDocuments;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

