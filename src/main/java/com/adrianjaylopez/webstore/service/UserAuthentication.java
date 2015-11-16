package com.adrianjaylopez.webstore.service;

import com.adrianjaylopez.webstore.dao.User;
import com.adrianjaylopez.webstore.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Adrian J Lopez
 *
 * @version 1.0
 * @since <pre>11/12/15</pre>
 */

@Service
public class UserAuthentication implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username/password");
        }
        String password = user.getPassword();
        if(!password.equals(token.getCredentials())){
            throw new BadCredentialsException("Invalid username/password");
        }
        List<GrantedAuthority> auth;
        String userAuth = user.getUserAuth();
        if (userAuth.compareTo("ROLE_ADMIN") == 0)
            auth = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
        else
            auth = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new UsernamePasswordAuthenticationToken(user, password, auth);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
