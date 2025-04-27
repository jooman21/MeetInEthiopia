package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.mapper;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto.ParticipantRegistrationDTO;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity.Participant;

public class participantMapper {
    //Converts the Participant entity (from the DB) into a ParticipantRegistrationDTO to send back to the client.
    public static ParticipantRegistrationDTO MapParticipantToParticipantRegistrationDTO(Participant participant) {
        return ParticipantRegistrationDTO.builder()
                .id(participant.getId())
                .fullName(participant.getFullName())
                .positionTitle(participant.getPosition_title())
                .organization(participant.getOrganization())
                .passportNumber(participant.getPassportNumber())
                .phoneNumber(participant.getPhoneNumber())
                .email(participant.getEmail())
                .emergencyContact(participant.getEmergency_contact())
                .participantCategory(participant.getParticipantCategory())
                .accessibilityNeeds(participant.getAccessibilityNeeds())
                .build();
    }

    public static Participant MapParticipantRegistrationDTOToParticipant(ParticipantRegistrationDTO dto) {
//    // Converts the ParticipantRegistrationDTO (received from the client) into a Participant entity to save into the database.
        Participant newParticipant = new Participant();
        newParticipant.setId(dto.getId());
        newParticipant.setFullName(dto.getFullName());
        newParticipant.setPosition_title(dto.getPositionTitle());
        newParticipant.setPassportNumber(dto.getPassportNumber());
        newParticipant.setOrganization(dto.getOrganization());
        newParticipant.setPhoneNumber(dto.getPhoneNumber());
        newParticipant.setEmail(dto.getEmail());
        newParticipant.setEmergency_contact(dto.getEmergencyContact());
        newParticipant.setParticipantCategory(dto.getParticipantCategory());
        newParticipant.setAccessibilityNeeds(dto.getAccessibilityNeeds());
        return  newParticipant;
        }
}

