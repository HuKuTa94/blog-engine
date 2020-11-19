package com.hukuta94.blog_engine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class-controller processes default requests not via the API (home page -/, in particular)
 * @autor Nikita Koshelev aka HuKuTa94
 */

@Controller
public class DefaultController
{
    @GetMapping( "/" )
    public String getIndexPage() {
        return "index";
    }
}
