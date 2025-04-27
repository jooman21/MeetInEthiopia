package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class MediaEquipmentClearance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String equipmentList;
    private String serialNumbers;
    private String purposeOfUse;
    private String temporaryImportDuration;
    private String storageTransportPlan;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @OneToOne
    @JoinColumn(name = "media_id")  // ➡️ foreign key to Media
    private Media media;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

