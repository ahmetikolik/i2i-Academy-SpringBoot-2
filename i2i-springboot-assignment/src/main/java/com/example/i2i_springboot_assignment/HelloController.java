package com.example.i2i_springboot_assignment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome to i2i Academy";
    }
}