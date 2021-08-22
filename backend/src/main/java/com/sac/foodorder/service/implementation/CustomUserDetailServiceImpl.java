package com.sac.foodorder.service.implementation;

import com.sac.foodorder.model.UserPrincipal;
import com.sac.foodorder.model.User;
import com.sac.foodorder.repository.UserRepository;
import com.sac.foodorder.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user);
    }
}
