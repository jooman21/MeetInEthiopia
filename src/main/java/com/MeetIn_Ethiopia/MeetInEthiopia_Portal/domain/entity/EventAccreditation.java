package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.ParticipantCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class EventAccreditation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;


    private ParticipantCategory participantCategory; // VIP, Delegate, Media
    private String photoIdUrl;
    private String affiliation;
    private String accessRequirements;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

