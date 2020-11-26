package com.hukuta94.blog_engine.api.response;

import com.hukuta94.blog_engine.model.dto.post.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Response for /api/post GET requests. Contains count and list of posts.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class PostResponse
{
    private long count;
    private List<PostDto> posts;
}
