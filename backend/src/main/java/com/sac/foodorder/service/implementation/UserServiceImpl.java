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
    public String createNewUser(String firstname, String lastname, String address, int mobile, String email, String username, String password) {
        if(StringUtil.isEmpty(firstname) || StringUtil.isEmpty(lastname) || StringUtil.isEmpty(address) || StringUtil.isEmpty(email) ||
                StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return "Every fields require to proceed";
        }
        if(!StringUtil.isValidEmail(email)) {
            return "Invalid email address, enter valid email address!";
        }
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return "Username available, try another username!";
        }
        user = userRepository.findByEmail(email);
        if(user != null) {
            return "This email has already registered, try to login or reset password!";
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
            return "unsuccessful";
        }
        return "successful";
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
    public String resetUserPassword(String password) {
        User user = getUser();
        user.setPassword(password);
        try {
            userRepository.save(user);
        } catch (Exception exception) {
            log.error("user did not update for username: " + user.getUsername());
            return "unsuccessful";
        }
        return "successful";
    }

    private User getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByUsername(username);
    }
}
