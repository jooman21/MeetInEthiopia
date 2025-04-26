package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.ParticipantCategory;
import jakarta.persistence.*;

@Entity
public class EventAccreditation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private ParticipantCategory participantCategory; // VIP, Delegate, Media
    private String photoIdUrl;
    private String affiliation;
    private String accessRequirements;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
}

