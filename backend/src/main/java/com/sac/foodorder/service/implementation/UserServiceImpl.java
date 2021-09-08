package com.sac.foodorder.service.implementation;

import com.sac.foodorder.enums.Response;
import com.sac.foodorder.model.User;
import com.sac.foodorder.repository.UserRepository;
import com.sac.foodorder.service.UserService;
import com.sac.foodorder.util.StringUtil;
import com.sac.foodorder.vo.CommonResponseVO;
import com.sac.foodorder.vo.UserDetailsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Sachith Harshamal
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public CommonResponseVO createNewUser(String firstname, String lastname, String address, int mobile, String email, String username, String password) {
        if(StringUtil.isEmpty(firstname) || StringUtil.isEmpty(lastname) || StringUtil.isEmpty(address) || StringUtil.isEmpty(email) ||
                StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return new CommonResponseVO(Response.INSUFFICIENT_DETAILS);
        }
        if(!StringUtil.isValidEmail(email)) {
            return new CommonResponseVO(Response.INVALID_EMAIL);
        }
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return new CommonResponseVO(Response.AVAILABLE_USERNAME);
        }
        user = userRepository.findByEmail(email);
        if(user != null) {
            return new CommonResponseVO(Response.AVAILABLE_EMAIL);
        }
        user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAddress(address);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setType("USER");
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            log.error("can not save user, " + exception);
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    @Override
    public UserDetailsVO getCurrentUserDetails() {
        User user = getUser();
        return new UserDetailsVO(
                user.getFirstname(),
                user.getLastname(),
                user.getAddress(),
                user.getMobile(),
                user.getEmail()
        );
    }

    @Override
    public CommonResponseVO resetUserPassword(String password) {
        User user = getUser();
        user.setPassword(password);
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            log.error("user did not update for username: " + user.getUsername());
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    private User getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByUsername(username);
    }
}
