package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.PartyRoomBooking;
import com.sac.foodorder.service.ChefService;
import com.sac.foodorder.service.ItemService;
import com.sac.foodorder.service.PartyRoomBookingService;
import com.sac.foodorder.service.PartyRoomService;
import com.sac.foodorder.service.SummaryService;
import com.sac.foodorder.vo.ChartSummaryVO;
import com.sac.foodorder.vo.CommonResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@Api(tags = "Admin")
@RequestMapping("api/v1/admin")
public class AdminController {

    private final ItemService itemService;
    private final ChefService chefService;
    private final PartyRoomService partyRoomService;
    private final PartyRoomBookingService partyRoomBookingService;
    private final SummaryService summaryService;

    public AdminController(ItemService itemService, ChefService chefService, PartyRoomService partyRoomService, PartyRoomBookingService partyRoomBookingService, SummaryService summaryService) {
        this.itemService = itemService;
        this.chefService = chefService;
        this.partyRoomService = partyRoomService;
        this.partyRoomBookingService = partyRoomBookingService;
        this.summaryService = summaryService;
    }

    @ApiOperation(value = "Create a new item")
    @PostMapping(path="/food-item/new-item")
    public CommonResponseVO saveNewItem(
            @RequestParam("title") String title,
            @RequestParam("item") String item,
            @RequestParam("description") String description,
            @RequestParam("currency") String currency,
            @RequestParam("price") int price,
            @RequestParam("type") String type,
            @RequestParam("image") String image){

        return itemService.saveNewItem(title, item, description, currency, price, type, image);
    }

    @ApiOperation(value = "Update an available item")
    @PutMapping(path="/food-item/update-item")
    public CommonResponseVO updateItem(
            @RequestParam("code") int code,
            @RequestParam("description") String description,
            @RequestParam("currency") String currency,
            @RequestParam("price") int price,
            @RequestParam("type") String type) throws DataNullException {

        return itemService.updateItem(code, description, currency, price, type);
    }

    @ApiOperation(value = "Delete an available item")
    @DeleteMapping(path="/food-item/delete-item/{code}")
    public CommonResponseVO deleteItem(@PathVariable("code") int code) throws DataNullException, IOException {
        return itemService.deleteItem(code);
    }

    @ApiOperation(value = "New chef")
    @PostMapping(path="/chef/new-chef", produces= {"application/json"})
    public CommonResponseVO saveNewChef(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("experience") int experience,
            @RequestParam("skill") String skill,
            @RequestParam("price") double price ) throws DataNullException {
        return chefService.saveNewChef(firstName, lastName, gender, experience, skill, price);
    }

    @ApiOperation(value = "Change chef's available status")
    @PostMapping(path="/chef/change-status-of-a-chef", produces= {"application/json"})
    public CommonResponseVO changeStatusOfAChef(@RequestParam("chefId") long chefId, @RequestParam("status") String status) throws DataNullException {
        return chefService.changeStatusOfAChef(chefId, status);
    }

    @ApiOperation(value = "Update available chef details")
    @PutMapping(path="/chef/update-chef", produces= {"application/json"})
    public CommonResponseVO updateChef(
            @RequestParam("chefId") long chefId,
            @RequestParam("experience") int experience,
            @RequestParam("skill") String skill,
            @RequestParam("price") double price ) throws DataNullException {
        return chefService.updateChef(chefId, price, skill, experience);
    }

    @ApiOperation(value = "Delete a chef")
    @DeleteMapping(path="/chef/delete-chef/{chefId}", produces= {"application/json"})
    public CommonResponseVO updateChef(@PathVariable("chefId") long chefId) {
        return chefService.deleteChef(chefId);
    }

    @ApiOperation(value = "Add a new room data")
    @PostMapping(path="/party-room/new-room", produces= {"application/json"})
    public CommonResponseVO saveNewRoom(
            @RequestParam("price") double price,
            @RequestParam("capacity") int capacity) {

        return partyRoomService.saveNewRoom(price, capacity);
    }

    @ApiOperation(value = "Update an available room details")
    @PutMapping(path="/party-room/update-room", produces= {"application/json"})
    public CommonResponseVO updateRoomDetails(
            @RequestParam("roomId") long roomId,
            @RequestParam("price") double price,
            @RequestParam("capacity") int capacity) throws DataNullException {

        return partyRoomService.updateRoomDetails(roomId, price, capacity);
    }

    @ApiOperation(value = "Delete an available room")
    @DeleteMapping(path="/party-room/delete-room/{roomId}", produces= {"application/json"})
    public CommonResponseVO deleteARoom(@PathVariable("roomId") long roomId) throws DataNullException {
        return partyRoomService.deleteARoom(roomId);
    }

    @ApiOperation(value = "Find all the room records")
    @GetMapping(path="/party-room-record/find-records", produces= {"application/json"})
    public List<PartyRoomBooking> findAllBookingRecords() {
        return partyRoomBookingService.findAllBookingRecords();
    }

    @ApiOperation(value = "Find a single room record")
    @GetMapping(path="/party-room-record/find-record/{recordId}", produces= {"application/json"})
    public PartyRoomBooking findARecord(@PathVariable("recordId") long recordId) throws DataNullException {
        return partyRoomBookingService.findARecord(recordId);
    }

    @ApiOperation(value = "Find room records by user")
    @GetMapping(path="/party-room-record/find-records/{userId}", produces= {"application/json"})
    public List<PartyRoomBooking> findRecordsByUser(@PathVariable("userId") int userId) throws DataNullException {
        return partyRoomBookingService.findRecordsByUser(userId);
    }

    @ApiOperation(value = "Find monthly sales data")
    @GetMapping(path="/summary/monthly-sales/{startTime}/{endTime}", produces= {"application/json"})
    public ChartSummaryVO findOrderMonthlyChart(@PathVariable("startTime") long startTime, @PathVariable("endTime") long endTime) throws ParseException {
        return summaryService.getMonthlyCharts(startTime, endTime);
    }
}
