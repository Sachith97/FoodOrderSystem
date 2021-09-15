package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.service.ItemService;
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
    @GetMapping(path="/find-items/{itemCode}", produces= {"application/json"})
    public ItemData findAItemByCode(@PathVariable("itemCode") int code) throws DataNullException {
        return itemService.findAItemByCode(code);
    }

    @ApiOperation(value = "Find a single food item data by name")
    @GetMapping(path="/find-items/{title}", produces= {"application/json"})
    public List<ItemData> findAItemsByTitle(@PathVariable("title") String title) {
        return itemService.findItemsByTitle(title);
    }

    @ApiOperation(value = "Create a new item")
    @PostMapping(path="/new-item")
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
    @PutMapping(path="/update-item")
    public CommonResponseVO updateItem(
            @RequestParam("code") int code,
            @RequestParam("description") String description,
            @RequestParam("currency") String currency,
            @RequestParam("price") int price,
            @RequestParam("type") String type) throws DataNullException {

        return itemService.updateItem(code, description, currency, price, type);
    }

    @ApiOperation(value = "Delete an available item")
    @DeleteMapping(path="/delete-item/{code}")
    public CommonResponseVO deleteItem(@PathVariable("code") int code) throws DataNullException, IOException {
        return itemService.deleteItem(code);
    }
}
