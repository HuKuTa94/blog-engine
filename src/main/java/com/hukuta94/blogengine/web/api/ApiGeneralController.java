package com.hukuta94.blogengine.web.api;

import com.hukuta94.blogengine.domain.bloginfo.model.BlogInfoDto;
import com.hukuta94.blogengine.domain.tag.model.TagResultDto;
import com.hukuta94.blogengine.dao.globalsettings.service.GlobalSettingsService;
import com.hukuta94.blogengine.dao.tag.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

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
    private final BlogInfoDto blogInfoDto;
    private final GlobalSettingsService globalSettingsService;
    private final TagService tagService;

    @GetMapping( "/init" )
    public BlogInfoDto getInit() {
        return blogInfoDto;
    }

    @GetMapping( "/settings" )
    public ResponseEntity< Map<String, Boolean> > getSettings() {
        return ResponseEntity.ok( globalSettingsService.getSettings() );
    }

    @GetMapping( "/tag" )
    public TagResultDto getTags() {
        return tagService.getTags();
    }
}
