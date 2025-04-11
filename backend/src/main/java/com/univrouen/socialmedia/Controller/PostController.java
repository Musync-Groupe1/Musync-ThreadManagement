package com.univrouen.socialmedia.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/posts")
public class PostController {

    @PostMapping("/create")
    public void createPost(){

    }
}
