package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.serviceImpl;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto.ParticipantRegistrationDTO;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.mapper.participantMapper;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.repository.ParticipantRepository;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.service.ParticipantService;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity.Participant;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.exception.ParticipantAlreadyExists;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.exception.RegistrationFieldsMutNotBeNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class participantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;



    @Override
    public ParticipantRegistrationDTO registerParticipant(ParticipantRegistrationDTO dto) {
        validateParticipantRegistrationDto(dto);

        if (participantRepository.findByPassportNumber(dto.getPassportNumber()).isPresent()) {
            throw new ParticipantAlreadyExists(
                    "Participant with passport number '" + dto.getPassportNumber() + "' already exists.");
        }

        // Map DTO to Entity
        Participant participant = participantMapper.MapParticipantRegistrationDTOToParticipant(dto);

        // Save to database
        Participant savedParticipant = participantRepository.save(participant);

        // Map back Entity to DTO to return
        return participantMapper.MapParticipantToParticipantRegistrationDTO(savedParticipant);

    }
    private void validateParticipantRegistrationDto(ParticipantRegistrationDTO dto) {
        if (dto.getFullName() == null || dto.getFullName().trim().isEmpty()) {
            throw new RegistrationFieldsMutNotBeNull("Full name must not be null or empty.");
        }
        if (dto.getPassportNumber() == null || dto.getPassportNumber().trim().isEmpty()) {
            throw new RegistrationFieldsMutNotBeNull("Passport number must not be null or empty.");
        }
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            throw new RegistrationFieldsMutNotBeNull("Email must not be null or empty.");
        }
        if (dto.getPhoneNumber() == null || dto.getPhoneNumber().trim().isEmpty()) {
            throw new RegistrationFieldsMutNotBeNull("Phone number must not be null or empty.");
        }
        if (dto.getOrganization() == null || dto.getOrganization().trim().isEmpty()) {
            throw new RegistrationFieldsMutNotBeNull("Organization must not be null or empty.");
        }
        if (dto.getParticipantCategory() == null) {
            throw new RegistrationFieldsMutNotBeNull("Participant category must not be null.");
        }
       if(dto.getAccessibilityNeeds() == null){
           throw new RegistrationFieldsMutNotBeNull ("Participant AccessibilityNeeds must not be null");
       }
        if(dto.getEmergencyContact() == null){
            throw new RegistrationFieldsMutNotBeNull ("Participant Emergency Contact must not be null");
        }
        if(dto.getPositionTitle() == null){
            throw new RegistrationFieldsMutNotBeNull ("Participant Position Title must not be null");
        }
    }


    }