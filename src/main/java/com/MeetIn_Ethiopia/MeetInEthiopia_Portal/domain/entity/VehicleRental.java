package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity;


import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.DriverRequirements;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.TypeOfVehicle;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VehicleRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TypeOfVehicle typeOfVehicle; // standard, chauffeured, armored
    private String duration;
    private DriverRequirements driverRequirements;
    private int numberOfVehicles;
    @OneToMany(mappedBy = "vehicleRental", cascade = CascadeType.ALL)
    private List<Itinerary> itineraries = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
