package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoom;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface PartyRoomService {

    List<PartyRoom> findAllPartyRooms();

    PartyRoom findARoom(long roomId) throws DataNullException;

    String saveNewRoom(double price, int capacity);

    String updateRoomDetails(long roomId, double price, int capacity) throws DataNullException;

    String updateBookingStatus(long roomId, String status) throws DataNullException;

    String deleteARoom(long roomId) throws DataNullException;
}
