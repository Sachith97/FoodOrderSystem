package com.sac.foodorder.repository;

import com.sac.foodorder.model.PartyRoomBooking;
import com.sac.foodorder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartyRoomBookingRepository extends JpaRepository<PartyRoomBooking, Long> {

    List<PartyRoomBooking> findByUser(User user);
}
