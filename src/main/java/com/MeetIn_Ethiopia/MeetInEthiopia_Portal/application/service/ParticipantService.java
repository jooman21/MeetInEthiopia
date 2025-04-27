package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.service;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto.ParticipantRegistrationDTO;
import org.springframework.stereotype.Service;


public interface ParticipantService {
    ParticipantRegistrationDTO registerParticipant(ParticipantRegistrationDTO dto);
}
