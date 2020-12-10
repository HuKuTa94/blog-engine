package com.hukuta94.blogengine.web;

import com.hukuta94.blogengine.dao.post.service.StatisticsService;
import com.hukuta94.blogengine.domain.bloginfo.model.BlogInfoDto;
import com.hukuta94.blogengine.domain.post.model.PostCountByYearResultDto;
import com.hukuta94.blogengine.domain.post.model.PostStatisticsResultDto;
import com.hukuta94.blogengine.domain.tag.model.TagResultDto;
import com.hukuta94.blogengine.dao.globalsettings.service.GlobalSettingsService;
import com.hukuta94.blogengine.dao.tag.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * Class-controller processes all other API requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @Version 1.01
 */

@RestController
@RequestMapping( "/api" )
@AllArgsConstructor
public class ApiGeneralController
{
    private final BlogInfoDto blogInfoDto;
    private final GlobalSettingsService globalSettingsService;
    private final TagService tagService;
    private final StatisticsService statisticsService;


    @GetMapping( "/init" )
    public BlogInfoDto getInit() {
        return blogInfoDto;
    }

    @GetMapping( "/settings" )
    public ResponseEntity< Map<String, Boolean> > getSettings() {
        return ResponseEntity.ok( globalSettingsService.getSettings() );
    }

    @GetMapping( "/tag" )
    public TagResultDto getTags(
            @RequestParam( value = "query", required = false ) String query
    ) {
        return tagService.getTags( query );
    }

    @GetMapping( "/calendar" )
    public ResponseEntity<PostCountByYearResultDto> getPostsSortedByMode(
            @RequestParam( value = "year", required = false ) Integer year
    ) {
        return ResponseEntity.ok( statisticsService.countOfPostsByYear( year ));
    }

    @GetMapping( "/statistics/all" )
    public PostStatisticsResultDto getPostStatisticsGeneral() {
        return statisticsService.getGeneralPostStatistics();
    }
}
