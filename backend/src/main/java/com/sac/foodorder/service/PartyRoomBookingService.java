package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoomBooking;
import com.sac.foodorder.vo.CommonResponseVO;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface PartyRoomBookingService {

    List<PartyRoomBooking> findAllBookingRecords();

    PartyRoomBooking findARecord(long recordId) throws DataNullException;

    List<PartyRoomBooking> findRecordsByUser(int userId) throws DataNullException;

    CommonResponseVO addNewRecord(long partyRoomId) throws DataNullException;

    CommonResponseVO changeStatusOfARecord(long recordId, String status) throws DataNullException;
}
