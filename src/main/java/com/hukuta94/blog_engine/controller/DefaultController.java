package com.hukuta94.blog_engine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * обрабатывает обычные запросы не через API (главная страница - /, в частности)
 */

@Controller
public class DefaultController
{
    @GetMapping( "/" )
    public String getIndexPage() {
        return "index";
    }
}
