package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoom;
import com.sac.foodorder.vo.CommonResponseVO;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface PartyRoomService {

    List<PartyRoom> findAllPartyRooms();

    PartyRoom findARoom(long roomId) throws DataNullException;

    CommonResponseVO saveNewRoom(double price, int capacity);

    CommonResponseVO updateRoomDetails(long roomId, double price, int capacity) throws DataNullException;

    CommonResponseVO updateBookingStatus(long roomId, String status) throws DataNullException;

    CommonResponseVO deleteARoom(long roomId) throws DataNullException;
}
