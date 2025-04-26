package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;


import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.PreferredHotelType;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.SpecialRequests;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PreferredHotelType preferredHotelType;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int numberOfGuests;
    @Enumerated(EnumType.STRING)
    private SpecialRequests specialRequests;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
}
