package com.hukuta94.blog_engine.controller;

import com.hukuta94.blog_engine.api.response.InitResponse;
import com.hukuta94.blog_engine.api.response.TagResponse;
import com.hukuta94.blog_engine.service.GlobalSettingsService;
import com.hukuta94.blog_engine.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Class-controller processes all other API requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @Version 1.0
 */

@RestController
@RequestMapping( "/api" )
@AllArgsConstructor
public class ApiGeneralController
{
    private final InitResponse initResponse;
    private final GlobalSettingsService globalSettingsService;
    private final TagService tagService;

    @GetMapping( "/init" )
    public InitResponse getInit() {
        return initResponse;
    }

    @GetMapping( "/settings" )
    public ResponseEntity< Map<String, Boolean> > getSettings() {
        return ResponseEntity.ok( globalSettingsService.getSettings() );
    }

    @GetMapping( "/tag" )
    public TagResponse getTags() {
        return tagService.getTags();
    }
}
