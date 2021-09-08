package com.sac.foodorder.service;

import com.sac.foodorder.vo.CommonResponseVO;
import com.sac.foodorder.vo.UserDetailsVO;

public interface UserService {

    String createNewUser(
            String firstname,
            String lastname,
            String address,
            int mobile,
            String email,
            String username,
            String password
    );

    UserDetailsVO getCurrentUserDetails();

    String resetUserPassword(String password);
}
