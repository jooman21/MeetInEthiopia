package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;

import jakarta.persistence.*;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mediaOutlet; // E.g., BBC, CNN, Al Jazeera
    private String mediaType;   // E.g., Journalist, Photographer, Cameraperson
    private boolean approved;   // Is the media accreditation approved?
    private String accreditationNumber; // Unique ID for their badge

    private String accessAreas; // (Optional) E.g., "Press Conference, Main Stage"

    @OneToOne
    @JoinColumn(name = "participant_id")  // who applied for media accreditation
    private Participant participant;

    @OneToOne(mappedBy = "media", cascade = CascadeType.ALL)
    private MediaEquipmentClearance mediaEquipmentClearance;
}

