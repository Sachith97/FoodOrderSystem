package com.sac.foodorder.controller;

import com.sac.foodorder.service.UserService;
import com.sac.foodorder.vo.UserDetailsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Users")
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Find customized details of current user")
    @GetMapping(path="/current-user", produces= {"application/json"})
    public UserDetailsVO findCurrentUserDetails() {
        return userService.getCurrentUserDetails();
    }

    @ApiOperation(value = "Update the login password of current user")
    @PutMapping(path="/current-user/update-password", produces= {"application/json"})
    public String resetUserPassword(@RequestParam("password") String password) {
        return userService.resetUserPassword(password);
    }
}
