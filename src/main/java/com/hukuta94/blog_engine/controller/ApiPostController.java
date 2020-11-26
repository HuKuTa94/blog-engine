package com.hukuta94.blog_engine.controller;

import com.hukuta94.blog_engine.api.response.PostResponse;
import com.hukuta94.blog_engine.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class-controller processes all requests /api/post/*
 * @autor Nikita Koshelev aka HuKuTa94
 */

@RestController
@RequestMapping( "/api" )
@AllArgsConstructor
public class ApiPostController
{
    private PostService service;

    @GetMapping( "/post" )
    public ResponseEntity<PostResponse> getPageablePosts(
            @RequestParam( value = "offset", defaultValue = "0" ) int offset,
            @RequestParam( value = "limit", defaultValue = "10" ) int limit,
            @RequestParam( value = "mode", defaultValue = "recent" ) String mode
    ) {
        return service.getSortedPostsWithOffsetAndLimit( offset, limit, mode );
    }
}
