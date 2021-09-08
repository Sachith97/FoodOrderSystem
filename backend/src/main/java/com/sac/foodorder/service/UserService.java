package com.sac.foodorder.service;

import com.sac.foodorder.model.User;
import com.sac.foodorder.vo.CommonResponseVO;
import com.sac.foodorder.vo.UserDetailsVO;

public interface UserService {

    CommonResponseVO createNewUser(
            String firstname,
            String lastname,
            String address,
            int mobile,
            String email,
            String username,
            String password
    );

    UserDetailsVO getCurrentUserDetails();

    CommonResponseVO resetUserPassword(String password);

    User getCurrentUser();
}
