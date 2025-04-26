package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class VisaAssistance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private LocalDate passportIssueDate;
    private LocalDate passportExpiryDate;
    private String issuingCountry;
    private String purposeOfVisit;
    private String lengthOfStay;
    private String previousTravelHistory;
    private boolean invitationLetterRequested;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
}
