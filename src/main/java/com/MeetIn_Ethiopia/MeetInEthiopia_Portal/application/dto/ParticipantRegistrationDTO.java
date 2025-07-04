package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.AccessibilityNeeds;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.ParticipantCategory;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.valueobject.Position_Title;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantRegistrationDTO {
    private UUID id;
    private String fullName;
    private Position_Title positionTitle;
    private String organization;
    private String nationality;
    private String passportNumber;
    private String email;
    private String phoneNumber;
    private String emergencyContact;
    private ParticipantCategory participantCategory;
    private AccessibilityNeeds accessibilityNeeds;
}
