package com.hukuta94.blogengine.domain.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response for /api/post?offset=X&limit=Y&mode=Z requests. Contains count and list of posts.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostOnMainPageResultDto
{
    private long count;
    private List<PostOnMainPageDto> posts;
}
