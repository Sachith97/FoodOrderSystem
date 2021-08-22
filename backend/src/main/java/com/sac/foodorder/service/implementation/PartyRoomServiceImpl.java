package com.sac.foodorder.service.implementation;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoom;
import com.sac.foodorder.repository.PartyRoomRepository;
import com.sac.foodorder.service.PartyRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sachith Harshamal
 */
@Service
public class PartyRoomServiceImpl implements PartyRoomService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private static final String AVAILABLE_STATUS = "available";
    private static final String UNAVAILABLE_STATUS = "unavailable";
    private static final String REMOVE_STATUS = "removed";

    private final PartyRoomRepository partyRoomRepository;

    public PartyRoomServiceImpl(PartyRoomRepository partyRoomRepository) {
        this.partyRoomRepository = partyRoomRepository;
    }

    @Override
    public List<PartyRoom> findAllPartyRooms() {
        return partyRoomRepository.findAll();
    }

    @Override
    public PartyRoom findARoom(long roomId) throws DataNullException {
        Optional<PartyRoom> optionalPartyRoom = partyRoomRepository.findById(roomId);
        if(!optionalPartyRoom.isPresent()) {
            throw new DataNullException("no room available for room ID: " + roomId);
        }
        return optionalPartyRoom.get();
    }

    @Override
    public String saveNewRoom(double price, int capacity) {
        PartyRoom partyRoom = new PartyRoom();
        partyRoom.setPrice(price);
        partyRoom.setCapacity(capacity);
        partyRoom.setStatus(AVAILABLE_STATUS);

        try {
            partyRoomRepository.save(partyRoom);
        } catch (Exception e) {
            log.error("error occurred in inserting phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String updateRoomDetails(long roomId, double price, int capacity) throws DataNullException {
        Optional<PartyRoom> optionalPartyRoom = partyRoomRepository.findById(roomId);
        if(!optionalPartyRoom.isPresent()) {
            throw new DataNullException("requested room not available for room id: " + roomId);
        }

        PartyRoom partyRoom = optionalPartyRoom.get();
        partyRoom.setPrice(price);
        partyRoom.setCapacity(capacity);

        try {
            partyRoomRepository.save(partyRoom);
        } catch (Exception e) {
            log.error("error occurred in updating phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String updateBookingStatus(long roomId, String status) throws DataNullException {
        Optional<PartyRoom> optionalPartyRoom = partyRoomRepository.findById(roomId);
        if(!optionalPartyRoom.isPresent()) {
            throw new DataNullException("requested room not available for room id: " + roomId);
        }

        PartyRoom partyRoom = optionalPartyRoom.get();
        if(status.equals("available")) {
            partyRoom.setStatus(AVAILABLE_STATUS);
        } else if(status.equals("unavailable")) {
            partyRoom.setStatus(UNAVAILABLE_STATUS);
        }

        try {
            partyRoomRepository.save(partyRoom);
        } catch (Exception e) {
            log.error("error occurred in updating phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String deleteARoom(long roomId) throws DataNullException {
        Optional<PartyRoom> optionalPartyRoom = partyRoomRepository.findById(roomId);
        if(!optionalPartyRoom.isPresent()) {
            throw new DataNullException("requested room not available for room id: " + roomId);
        }

        PartyRoom partyRoom = optionalPartyRoom.get();
        partyRoom.setStatus(REMOVE_STATUS);

        try {
            partyRoomRepository.save(partyRoom);
        } catch (Exception e) {
            log.error("error occurred in deleting phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }
}
