package com.hukuta94.blogengine.web.api.post;

import com.hukuta94.blogengine.dao.post.service.MultiPostService;
import com.hukuta94.blogengine.dao.post.service.SinglePostService;
import com.hukuta94.blogengine.domain.post.model.PostByIdResultDto;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageResultDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class-controller processes all requests /api/post/*
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.01
 */

@RestController
@RequestMapping( "/api" )
@AllArgsConstructor
public class PostController
{
    private MultiPostService multiPostService;
    private SinglePostService singlePostService;

    @GetMapping( "/post" )
    public ResponseEntity<PostOnMainPageResultDto> getPostsByMode(
            @RequestParam( value = "offset", defaultValue = "0" ) int offset,
            @RequestParam( value = "limit", defaultValue = "10" ) int limit,
            @RequestParam( value = "mode" ) String mode
    ) {
        return multiPostService.getPostsSortedByMode( offset, limit, mode );
    }

    @GetMapping( "/post/byTag" )
    public ResponseEntity<PostOnMainPageResultDto> getPostsByTag(
            @RequestParam( value = "offset", defaultValue = "0" ) int offset,
            @RequestParam( value = "limit", defaultValue = "10" ) int limit,
            @RequestParam( value = "tag" ) String tag
    ) {
        return multiPostService.getPostsByTag( offset, limit, tag );
    }

    @GetMapping( "/post/byDate" )
    public ResponseEntity<PostOnMainPageResultDto> getPostsByDate(
            @RequestParam( value = "offset", defaultValue = "0" ) int offset,
            @RequestParam( value = "limit", defaultValue = "10" ) int limit,
            @RequestParam( value = "date" ) String date
    ) {
        return multiPostService.getPostsSortedByOneDate( offset, limit, date );
    }

    @GetMapping( "/post/{id}" )
    public ResponseEntity<PostByIdResultDto> getPostById( @PathVariable( "id") int id ) {
        return singlePostService.getPostById( id );
    }
}
