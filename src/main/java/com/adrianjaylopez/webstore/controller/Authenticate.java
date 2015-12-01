package com.adrianjaylopez.webstore.controller;

import com.adrianjaylopez.webstore.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/** @author Adrian J Lopez
 * @since <pre>11/30/15</pre>
 * @version 1.0
 */
@RestController
public class Authenticate {

    @Autowired
    private AuthenticationProvider authProvider;

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public User userInfo(@RequestBody User user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        token = (UsernamePasswordAuthenticationToken) authProvider.authenticate(token);
        user = (User) token.getPrincipal();

        return user;

    }
}
