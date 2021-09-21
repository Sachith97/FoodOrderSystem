package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoom;
import com.sac.foodorder.service.PartyRoomService;
import com.sac.foodorder.vo.CommonResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Party Rooms")
@RequestMapping("/api/v1/party-rooms")
public class PartyRoomController {

    private final PartyRoomService partyRoomService;

    public PartyRoomController(PartyRoomService partyRoomService) {
        this.partyRoomService = partyRoomService;
    }

    @ApiOperation(value = "Find all the party rooms")
    @GetMapping(path="/find-rooms", produces= {"application/json"})
    public List<PartyRoom> findAllPartyRooms() {
        return partyRoomService.findAllPartyRooms();
    }

    @ApiOperation(value = "Find a single party room")
    @GetMapping(path="/find-rooms/{roomId}", produces= {"application/json"})
    public PartyRoom findARoom(@PathVariable("roomId") long roomId) throws DataNullException {
        return partyRoomService.findARoom(roomId);
    }

    @ApiOperation(value = "Update a room's available status")
    @PutMapping(path="/update-status")
    public CommonResponseVO updateBookingStatus(
            @RequestParam("roomId") long roomId,
            @RequestParam("status") String status) throws DataNullException {

        return partyRoomService.updateBookingStatus(roomId, status);
    }
}
