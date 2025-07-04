package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;


import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.AccessibilityNeeds;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.ParticipantCategory;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.Position_Title;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String fullName;
    @Enumerated(EnumType.STRING)
    private Position_Title position_title;
    private String organization;
    private String nationality;
    private String passportNumber;
    private String email;
    private String phoneNumber;
    private String emergency_contact;

    @Enumerated(EnumType.STRING)
    private ParticipantCategory participantCategory;

    @Enumerated(EnumType.STRING)
    private AccessibilityNeeds accessibilityNeeds;

    @ManyToMany
    private List<Event> events;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private Accommodation accommodation;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private VehicleRental vehicleRental;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private VisaAssistance visaAssistance;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private SpecialFlightPermit flightPermit;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private WeaponsClearance weaponsClearance;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private RadioClearance radioClearance;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private MediaEquipmentClearance mediaEquipmentClearance;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private EventAccreditation accreditation;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private PostEventActivity postEventActivity;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private VIPSalonPermit vipSalonPermit;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private CustomsClearance customsClearance;

    @OneToOne(mappedBy = "participant", cascade = CascadeType.ALL)
    private Media media;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
