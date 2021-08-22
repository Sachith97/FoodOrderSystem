package com.sac.foodorder.service.implementation;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoom;
import com.sac.foodorder.model.PartyRoomBooking;
import com.sac.foodorder.model.User;
import com.sac.foodorder.repository.PartyRoomBookingRepository;
import com.sac.foodorder.repository.PartyRoomRepository;
import com.sac.foodorder.repository.UserRepository;
import com.sac.foodorder.service.PartyRoomBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Sachith Harshamal
 */
@Service
public class PartyRoomBookingServiceImpl implements PartyRoomBookingService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private static final String PENDING_STATUS = "pending";
    private static final String COMPLETE_STATUS = "complete";
    private static final String CLOSE_STATUS = "close";

    private final PartyRoomBookingRepository partyRoomBookingRepository;
    private final UserRepository userRepository;
    private final PartyRoomRepository partyRoomRepository;

    public PartyRoomBookingServiceImpl(PartyRoomBookingRepository partyRoomBookingRepository, UserRepository userRepository, PartyRoomRepository partyRoomRepository) {
        this.partyRoomBookingRepository = partyRoomBookingRepository;
        this.userRepository = userRepository;
        this.partyRoomRepository = partyRoomRepository;
    }

    @Override
    public List<PartyRoomBooking> findAllBookingRecords() {
        return partyRoomBookingRepository.findAll();
    }

    @Override
    public PartyRoomBooking findARecord(long recordId) throws DataNullException {
        Optional<PartyRoomBooking> optionalPartyRoomBooking = partyRoomBookingRepository.findById(recordId);
        if(!optionalPartyRoomBooking.isPresent()) {
            throw new DataNullException("no record available for record ID: " + recordId);
        }
        return optionalPartyRoomBooking.get();
    }

    @Override
    public List<PartyRoomBooking> findRecordsByUser(int userId) throws DataNullException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new DataNullException("no user available for user ID: " + userId);
        }
        return partyRoomBookingRepository.findByUser(optionalUser.get());
    }

    @Override
    public String addNewRecord(int userId, long partyRoomId) throws DataNullException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new DataNullException("no user available for user ID: " + userId);
        }

        Optional<PartyRoom> optionalPartyRoom = partyRoomRepository.findById(partyRoomId);
        if(!optionalPartyRoom.isPresent()) {
            throw new DataNullException("no room available for room ID: " + partyRoomId);
        }

        Date currentDateTime = new Date();

        PartyRoomBooking partyRoomBooking = new PartyRoomBooking();
        partyRoomBooking.setPartyRoom(optionalPartyRoom.get());
        partyRoomBooking.setUser(optionalUser.get());
        partyRoomBooking.setStatus(PENDING_STATUS);
        partyRoomBooking.setOrderDate(currentDateTime);
        partyRoomBooking.setOrderTime(currentDateTime);

        try {
            partyRoomBookingRepository.save(partyRoomBooking);
        } catch (Exception e) {
            log.error("error occurred in inserting phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String changeStatusOfARecord(long recordId, String status) throws DataNullException {
        Optional<PartyRoomBooking> optionalPartyRoomBooking = partyRoomBookingRepository.findById(recordId);
        if(!optionalPartyRoomBooking.isPresent()) {
            throw new DataNullException("no record available for record ID: " + recordId);
        }

        PartyRoomBooking partyRoomBooking = optionalPartyRoomBooking.get();
        if(status.equals("complete")) {
            partyRoomBooking.setStatus(COMPLETE_STATUS);
        } else if(status.equals("close")) {
            partyRoomBooking.setStatus(CLOSE_STATUS);
        }

        try {
            partyRoomBookingRepository.save(partyRoomBooking);
        } catch (Exception e) {
            log.error("error occurred in updating phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }
}
