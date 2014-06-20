package com.railroad.service;

import com.railroad.model.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Elena on 6/11/2014.
 */
@Service
public class UserManager {

    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<String, User>();
        users.put("admin", new User("admin", "1111", "ROLE_USER, ROLE_ADMIN"));
    }

    public User getUser(String username) throws UsernameNotFoundException{
        if( !users.containsKey( username ) ){
            throw new UsernameNotFoundException( username + " not found" );
        }

        return users.get( username );
    }
}
