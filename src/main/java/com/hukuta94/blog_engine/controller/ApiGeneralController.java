package com.hukuta94.blog_engine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class-controller processes all other API requests
 * @autor Nikita Koshelev aka HuKuTa94
 */

@RestController
public class ApiGeneralController
{
    @GetMapping( "/api/init" )
    public int getInit() {
        return 777;
    }
}
