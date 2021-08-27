package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.Chef;
import com.sac.foodorder.service.ChefService;
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

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Chefs")
@RequestMapping("/api/v1/chef")
public class ChefController {

    private final ChefService chefService;

    public ChefController(ChefService chefService) {
        this.chefService = chefService;
    }

    @ApiOperation(value = "All the chefs")
    @GetMapping(path="/find-chefs", produces= {"application/json"})
    public List<Chef> findAllChefs() {
        return chefService.findAllChefs();
    }

    @ApiOperation(value = "All the available chefs")
    @GetMapping(path="/find-all-available-chefs", produces= {"application/json"})
    public List<Chef> findAllAvailableChefs() {
        return chefService.findAllAvailableChefs();
    }

    @ApiOperation(value = "All the busy chefs")
    @GetMapping(path="/find-all-busy-chefs", produces= {"application/json"})
    public List<Chef> findAllBusyChefs() {
        return chefService.findAllBusyChefs();
    }

    @ApiOperation(value = "Single chef data by ID")
    @GetMapping(path="/find-chefs/{chefId}", produces= {"application/json"})
    public Chef findAChefById(@PathVariable("chefId") long chefId) throws DataNullException {
        return chefService.findAChefById(chefId);
    }

    @ApiOperation(value = "New chef")
    @PostMapping(path="/new-chef", produces= {"application/json"})
    public String saveNewChef(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") String gender,
            @RequestParam("experience") int experience,
            @RequestParam("skill") String skill,
            @RequestParam("price") double price ) throws DataNullException {
        return chefService.saveNewChef(firstName, lastName, gender, experience, skill, price);
    }

    @ApiOperation(value = "Change chef's available status")
    @PostMapping(path="/change-status-of-a-chef", produces= {"application/json"})
    public String changeStatusOfAChef(@RequestParam("chefId") long chefId, @RequestParam("status") String status) throws DataNullException {
        return chefService.changeStatusOfAChef(chefId, status);
    }

    @ApiOperation(value = "Update available chef details")
    @PutMapping(path="/update-chef", produces= {"application/json"})
    public String updateChef(
            @RequestParam("chefId") long chefId,
            @RequestParam("experience") int experience,
            @RequestParam("skill") String skill,
            @RequestParam("price") double price ) throws DataNullException {
        return chefService.updateChef(chefId, price, skill, experience);
    }

    @ApiOperation(value = "Delete a chef")
    @DeleteMapping(path="/delete-chef/{chefId}", produces= {"application/json"})
    public String updateChef(@PathVariable("chefId") long chefId) {
        return chefService.deleteChef(chefId);
    }
}
