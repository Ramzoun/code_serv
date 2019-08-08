package com.luv2code.springboot.cruddemo.config;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
//import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;

import com.luv2code.springboot.cruddemo.service.LoginAttemptService;

@Component
public class SessionCreatedListenerService implements ApplicationListener<ApplicationEvent> {
/*
private static final Logger logger = LoggerFactory
        .getLogger(SessionCreatedListenerService.class);*/

	 @Autowired
	    private HttpServletRequest request;

	    @Autowired
	    private LoginAttemptService loginAttemptService;
	    
	    
@Autowired
HttpSession httpSession;

@Bean
public HttpSessionEventPublisher httpSessionEventPublisher() {
    return new HttpSessionEventPublisher();
}

@Override
public void onApplicationEvent(ApplicationEvent applicationEvent) {
    if(applicationEvent instanceof HttpSessionCreatedEvent){ //If event is a session created event

    	System.out.println("  session is created  :");

     }else if(applicationEvent instanceof HttpSessionDestroyedEvent){ //If event is a session destroy event
        // handler.expireCart();

         //logger.debug(""+(Long)httpSession.getAttribute("userId"));

         //logger.debug(" Session is destory  :" ); //log data
         System.out.println(" Session is destory  :" );

     }else if(applicationEvent instanceof AuthenticationSuccessEvent){ //If event is a session destroy event
         //logger.debug("  athentication is success  :" ); //log data
    	 System.out.println("  athentication is success  :");
     }else if(applicationEvent instanceof AuthenticationFailureBadCredentialsEvent){ //If event is a session destroy event
    	// final WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
         // if (auth != null) {
         // loginAttemptService.loginFailed(auth.getRemoteAddress());
         // }
         final String xfHeader = request.getHeader("X-Forwarded-For");
         if (xfHeader == null) {
             loginAttemptService.loginFailed(request.getRemoteAddr());
         } else {
             loginAttemptService.loginFailed(xfHeader.split(",")[0]);
         }
     }else{
         //logger.debug(" unknown event occur  : " Source: " + ); //log data
     }  
}   
}
    	 