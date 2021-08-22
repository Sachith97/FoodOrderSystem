package com.sac.foodorder.repository;

import com.sac.foodorder.model.PartyRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRoomRepository extends JpaRepository<PartyRoom, Long> {
}
