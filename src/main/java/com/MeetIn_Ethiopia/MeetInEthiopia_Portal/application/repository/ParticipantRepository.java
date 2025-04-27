package com.MeetIn_Ethiopia.MeetInEthiopia_Portal.application.repository;

import com.MeetIn_Ethiopia.MeetInEthiopia_Portal.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {


    Optional<Object> findByPassportNumber(String passportNumber);
}
