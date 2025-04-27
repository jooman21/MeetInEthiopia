package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class WeaponsClearance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String securityTeamDetails;
    private String weaponTypeQuantity;
    private String ammunitionDetails;
    private String storageTransportPlan;
    private String authorizingEntity;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

