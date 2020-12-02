package com.hukuta94.blogengine.dao.post.repository.statistics;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateAndPostCount;
import com.hukuta94.blogengine.dao.post.repository.statistics.calendar.IDateYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository of statistics of the blog with custom queries.
 * Interface uses Spring JPA projections by with IDate* interfaces.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.01
 */

@Repository
public interface StatisticsRepository extends JpaRepository<PostEntity, Integer>
{
    // Find all posts by date (years)
    @Query( value =
            """
            SELECT DATE_FORMAT(post.time, '%Y-%m-%d') AS postDate, COUNT(post) AS postCount
            FROM PostEntity AS post
            WHERE YEAR(post.time) = :year
            GROUP BY DATE_FORMAT(post.time, '%Y-%m-%d')
            """ )
    List<IDateAndPostCount> findAllPostsByYear(@Param( "year") int year );

    @Query( value =
            """
            SELECT DATE_FORMAT(post.time, '%Y') AS postDate
            FROM PostEntity AS post
            GROUP BY DATE_FORMAT(post.time, '%Y')
            """ )
    List<IDateYear> findAllYearsWithPosts();
}
