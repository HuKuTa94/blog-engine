package com.hukuta94.blogengine.web.api.post;

import com.hukuta94.blogengine.domain.post.model.PostByIdResultDto;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageResultDto;
import com.hukuta94.blogengine.dao.post.service.PostOnMainPageService;
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
public class PostController
{
    private PostOnMainPageService service;

    @GetMapping( "/post" )
    public ResponseEntity<PostOnMainPageResultDto> getPageablePosts(
            @RequestParam( value = "offset", defaultValue = "0" ) int offset,
            @RequestParam( value = "limit", defaultValue = "10" ) int limit,
            @RequestParam( value = "mode", defaultValue = "recent" ) String mode
    ) {
        return service.getSortedPostsWithOffsetAndLimit( offset, limit, mode );
    }

    @GetMapping ("/post/{id}" )
    public ResponseEntity<PostByIdResultDto> getPostById(@PathVariable( "id") int id ) {
        return service.getPostById( id );
    }
}
