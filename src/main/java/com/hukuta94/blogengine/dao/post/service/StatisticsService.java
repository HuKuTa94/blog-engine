package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.post.entity.PostStatisticsCache;
import com.hukuta94.blogengine.dao.post.repository.statistics.StatisticsRepository;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateAndPostCount;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateYear;
import com.hukuta94.blogengine.dao.post.repository.statistics.post.IPostStatistics;
import com.hukuta94.blogengine.dao.util.LocalDateTimeToLongConverter;
import com.hukuta94.blogengine.domain.post.model.PostCountByYearResultDto;
import com.hukuta94.blogengine.domain.post.model.PostStatisticsResultDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Service for processing /api/calendar request.
 * Service uses CalendarStatisticsRepository.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class StatisticsService
{
    private StatisticsRepository repository;
    private PostStatisticsCache postStatisticsCache;

    /**
     * Calendar statistics
     * @param year - posts published in this year
     * @return
     */
    public PostCountByYearResultDto countOfPostsByYear( Integer year ) {
        // Get list of years with 1 and more posts
        List<IDateYear> dateYears = repository.findAllYearsWithPosts();
        List<Integer> years = new ArrayList<>( dateYears.size() );
        for ( IDateYear item : dateYears ) {
            years.add( Integer.parseInt( item.getPostDate() ));
        }

        // If year param is null, return all years
        if ( year == null ) {
            year = LocalDateTime.now().getYear();
        }

        // Get posts count by dates
        List<IDateAndPostCount> dateAndPosts = repository.findAllPostsByYear( year );
        TreeMap<String, Integer> posts = new TreeMap<>();
        for( IDateAndPostCount item : dateAndPosts ) {
            posts.put( item.getPostDate(), item.getPostCount() );
        }

        return new PostCountByYearResultDto( years, posts );
    }

    //TODO Добавить показ статистики с учетом настройки блога STATISTICS_IS_PUBLIC и роли "Модератор"
    public synchronized PostStatisticsResultDto getGeneralPostStatistics() {
        if ( !postStatisticsCache.isTimeExpired() ) {
            return postStatisticsCache.getStatistics();
        }

        // Get new data from DB
        IPostStatistics statistics = repository.getPostStatistics();

        // Update statistics in cache
        PostStatisticsResultDto resultDto = postStatisticsCache.getStatistics();
        resultDto.setPostsCount( statistics.getPostsCount() );
        resultDto.setLikesCount( statistics.getLikesCount() );
        resultDto.setDislikesCount( statistics.getDislikesCount() );
        resultDto.setViewsCount( statistics.getViewsCount() );
        resultDto.setFirstPublication(
                LocalDateTimeToLongConverter.toMinutes(
                        statistics.getFirstPublication() ));

        return resultDto;
    }
}
