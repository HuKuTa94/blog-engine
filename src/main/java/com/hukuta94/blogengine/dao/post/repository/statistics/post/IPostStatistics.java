package com.hukuta94.blogengine.dao.post.repository.statistics.post;

import java.time.LocalDateTime;

/**
 * Interface-projection used by Spring JPA projections for post statistics
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

public interface IPostStatistics
{
    Integer getPostsCount();
    Integer getLikesCount();
    Integer getDislikesCount();
    Integer getViewsCount();
    LocalDateTime getFirstPublication();
}
