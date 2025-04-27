package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.controller;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto.ParticipantRegistrationDTO;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.service.ParticipantService;
import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.GlobalResponse.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participant")
public class ParticipantController {
    private final ParticipantService participantService;
    @PostMapping("/registerParticipant")
    public ResponseEntity<GenericResponse> registerParticipant(@RequestBody ParticipantRegistrationDTO participantRegistrationDTO) {
        participantService.registerParticipant(participantRegistrationDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new GenericResponse(true, "Participant registered successfully"));
    }
}
