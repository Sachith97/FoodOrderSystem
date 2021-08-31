package com.sac.foodorder.service;

import com.sac.foodorder.vo.UserDetailsVO;

public interface UserService {

    String createNewUser(
            String firstname,
            String lastname,
            String address,
            int mobile,
            String email,
            String username,
            String password,
            String type
    );

    UserDetailsVO getCurrentUserDetails();

    String resetUserPassword(String password);
}
