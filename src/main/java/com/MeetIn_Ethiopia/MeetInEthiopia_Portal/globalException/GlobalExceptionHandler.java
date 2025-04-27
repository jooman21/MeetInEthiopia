package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.globalException;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.exception.ParticipantAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(ParticipantAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleTicketTypeAlreadyExistsException(ParticipantAlreadyExists ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
