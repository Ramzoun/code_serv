package com.luv2code.springboot.cruddemo.service;



import org.springframework.stereotype.Service;


@Service
public class LoginAttemptService {

    //private final int MAX_ATTEMPT = 10;
    //private LoadingCache<String, Integer> attemptsCache;

    public LoginAttemptService() {
        
    }

    //

    public void loginSucceeded(final String key) {
        //attemptsCache.invalidate(key);
    }

    public void loginFailed(final String key) {
        System.out.println("___login failed___");
    }

    public boolean isBlocked(final String key) {
        return false;
    }
}
