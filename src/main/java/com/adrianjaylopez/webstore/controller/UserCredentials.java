package com.adrianjaylopez.webstore.controller;

/**
 * @author Adrian J Lopez
 * @version 1.0
 * @since <pre>10/4/15</pre>
 */
public class UserCredentials {
    /**
     * This class is a temporary placeholder to get the user type determined and
     * get the program working.
     * @param userName name of user
     * @param password users password
     * @return string listing the kind of user
     */
    public String userType(String userName, String password){
        if(userName.compareTo("admin") != 0 && password.compareTo("admin") != 0)
            return "user";
        else
            return "admin";
    }
}
