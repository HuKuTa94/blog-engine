package com.hukuta94.blogengine.domain.post.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response for /api/statisticks/* requests.
 * Contains general statistics of the blog or user's statistics of posts.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class PostStatisticsResultDto
{
    private int postsCount;
    private int likesCount;
    private int dislikesCount;
    private int viewsCount;
    private long firstPublication;
}
