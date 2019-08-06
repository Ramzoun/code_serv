package com.luv2code.springboot.cruddemo.rest;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
    @RequestMapping(value = "/res/{imgNum}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getImage(HttpServletResponse response, @PathVariable int imgNum) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("content_images/"+imgNum+".jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
    
    
    
    @RequestMapping(value = "/res/sound/{imgNum}", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)

    public void getSound(HttpServletResponse response, @PathVariable int imgNum) throws IOException {

        ClassPathResource soundFile = new ClassPathResource("sound/q1.wav");

        response.setContentType(MediaType.ALL_VALUE);
        StreamUtils.copy(soundFile.getInputStream(), response.getOutputStream());
    }
    
}