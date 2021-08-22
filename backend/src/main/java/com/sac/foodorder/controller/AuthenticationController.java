package com.sac.foodorder.controller;

import com.sac.foodorder.service.CustomUserDetailService;
import com.sac.foodorder.util.JwtTokenUtil;
import com.sac.foodorder.vo.AuthenticationRequestVO;
import com.sac.foodorder.vo.AuthenticationResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sachith Harshamal
 */
@RestController
@Api(tags = "Authentication", description = "Authenticate with JWT tokens")
@RequestMapping("api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Get JWT token to authorize
    @ApiOperation(value = "Get JWT token to authorize")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestVO authenticationRequestVO) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequestVO.getUsername(), authenticationRequestVO.getPassword())
            );
        }
        catch (BadCredentialsException badCredentialsException) {
            throw new Exception("Incorrect username or password", badCredentialsException);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestVO.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseVO(jwt));
    }
}
