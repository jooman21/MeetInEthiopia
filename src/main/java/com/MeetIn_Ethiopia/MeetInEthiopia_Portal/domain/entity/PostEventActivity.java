package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PostEventActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String preferredActivities;
    private int groupSize;
    private String activityDates;
    private String specialRequests;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
