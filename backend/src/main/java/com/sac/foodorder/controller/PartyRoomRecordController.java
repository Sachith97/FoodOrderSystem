package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoomBooking;
import com.sac.foodorder.service.PartyRoomBookingService;
import com.sac.foodorder.vo.CommonResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Party Room Records")
@RequestMapping("/api/v1/room-records")
public class PartyRoomRecordController {

    private final PartyRoomBookingService partyRoomBookingService;

    public PartyRoomRecordController(PartyRoomBookingService partyRoomBookingService) {
        this.partyRoomBookingService = partyRoomBookingService;
    }

    @ApiOperation(value = "Find all the room records")
    @GetMapping(path="/find-records", produces= {"application/json"})
    public List<PartyRoomBooking> findAllBookingRecords() {
        return partyRoomBookingService.findAllBookingRecords();
    }

    @ApiOperation(value = "Find a single room record")
    @GetMapping(path="/find-records/{recordId}", produces= {"application/json"})
    public PartyRoomBooking findARecord(@PathVariable("recordId") long recordId) throws DataNullException {
        return partyRoomBookingService.findARecord(recordId);
    }

    @ApiOperation(value = "Find room records by user")
    @GetMapping(path="/find-records/{userId}", produces= {"application/json"})
    public List<PartyRoomBooking> findRecordsByUser(@PathVariable("userId") int userId) throws DataNullException {
        return partyRoomBookingService.findRecordsByUser(userId);
    }

    @ApiOperation(value = "Add a new room record")
    @PostMapping(path="/new-record", produces= {"application/json"})
    public CommonResponseVO addNewRecord(
            @RequestParam("partyRoomId") long partyRoomId) throws DataNullException {

        return partyRoomBookingService.addNewRecord(partyRoomId);
    }

    @ApiOperation(value = "Update the status of a record")
    @PutMapping(path="/update-record", produces= {"application/json"})
    public CommonResponseVO changeStatusOfARecord(
            @RequestParam("recordId") long recordId,
            @RequestParam("status") String status) throws DataNullException {

        return partyRoomBookingService.changeStatusOfARecord(recordId, status);
    }
}
