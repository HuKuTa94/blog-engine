package com.hukuta94.blogengine.dao.post.entity;

import com.hukuta94.blogengine.domain.post.model.PostStatisticsResultDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Cache for storage of the post statistics with limited lifetime.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
//TODO Обеспечить многопоточную безопасность
@Component()
public class PostStatisticsCache
{
    private static final int STORAGE_TIME_MINUTES = 5;

    private LocalDateTime expirationTime;
    private PostStatisticsResultDto statistics;

    public PostStatisticsCache() {
        expirationTime = LocalDateTime.now();
        statistics = new PostStatisticsResultDto();
    }

    public PostStatisticsResultDto getStatistics() {
        return statistics;
    }

    public boolean isTimeExpired() {
        LocalDateTime timeNow = LocalDateTime.now();

        // Time is expired
        if( timeNow.isAfter( expirationTime )) {
            expirationTime = timeNow.plusMinutes( STORAGE_TIME_MINUTES );
            return true;
        }

        return false;
    }
}
