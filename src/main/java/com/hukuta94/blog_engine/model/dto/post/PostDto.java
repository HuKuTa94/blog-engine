package com.hukuta94.blog_engine.model.dto.post;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for processing /api/post response.
 * This class used by PostResponse to make a list of posts.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class PostDto
{
    private int id;
    private long timestamp;
    private String title;
    private String announce;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private long viewCount;
    private UserDto user;
}


