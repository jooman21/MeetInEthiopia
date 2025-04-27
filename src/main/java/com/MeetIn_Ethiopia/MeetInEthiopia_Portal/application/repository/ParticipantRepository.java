package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.repository;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {


    Optional<Object> findByPassportNumber(String passportNumber);
}
