package com.sac.foodorder.controller;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.UserCart;
import com.sac.foodorder.service.UserCartService;
import com.sac.foodorder.vo.CommonResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "User Cart")
@RequestMapping("/api/v1/user-cart")
public class UserCartController {

    private final UserCartService userCartService;

    public UserCartController(UserCartService userCartService) {
        this.userCartService = userCartService;
    }

    @ApiOperation(value = "Find all the cart details of the user")
    @GetMapping(path="/get-cart", produces= {"application/json"})
    public List<UserCart> getCartDetailsByUser() {
        return userCartService.getCartDetailsByUser();
    }

    @ApiOperation(value = "Add new cart detail")
    @PostMapping(path="/new-item", produces= {"application/json"})
    public CommonResponseVO newCartDetail(int itemCode, int quantity) throws DataNullException {
        return userCartService.newCartDetail(itemCode, quantity);
    }

    @ApiOperation(value = "Update available cart details")
    @PutMapping(path="/update-cart", produces= {"application/json"})
    public CommonResponseVO updateCartDetails(int itemCode, int quantity) throws DataNullException {
        return userCartService.updateCartDetails(itemCode, quantity);
    }

    @ApiOperation(value = "Delete a cart detail")
    @DeleteMapping(path="/delete-cart", produces= {"application/json"})
    public CommonResponseVO deleteCartDetails(int itemCode) throws DataNullException {
        return userCartService.deleteCartDetails(itemCode);
    }
}
