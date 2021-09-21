package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Food Items")
@RequestMapping("/api/v1/food-item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiOperation(value = "Find all the food items")
    @GetMapping(path="/find-items", produces= {"application/json"})
    public List<ItemData> findAllItems() {
        return itemService.findAllItems();
    }

    @ApiOperation(value = "Find a single food item data")
    @GetMapping(path="/find-item/{itemCode}", produces= {"application/json"})
    public ItemData findAItemByCode(@PathVariable("itemCode") int code) throws DataNullException {
        return itemService.findAItemByCode(code);
    }

    @ApiOperation(value = "Find a single food item data by title")
    @GetMapping(path="/find-items/{title}", produces= {"application/json"})
    public List<ItemData> findItemsByTitle(@PathVariable("title") String title) {
        return itemService.findItemsByTitle(title);
    }
}
