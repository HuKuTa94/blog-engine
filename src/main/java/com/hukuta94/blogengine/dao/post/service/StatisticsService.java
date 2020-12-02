package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.post.repository.statistics.StatisticsRepository;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateAndPostCount;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateYear;
import com.hukuta94.blogengine.domain.post.model.PostCountByYearResultDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

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
}
