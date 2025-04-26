package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantEventSelectionDTO {
    private Long participantId;
    private List<Long> eventIds;
}
