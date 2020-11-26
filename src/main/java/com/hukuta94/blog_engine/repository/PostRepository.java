package com.hukuta94.blog_engine.repository;

import com.hukuta94.blog_engine.model.entity.post.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of the posts with custom SQL requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Repository
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Integer>
{
    // Find by date
    @Query( value = "SELECT * FROM posts WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())",
            nativeQuery = true )
    Page<PostEntity> findAllPostsByDate( Pageable pageable );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfPostsByDate();


    // Find by comment count
    @Query( value =
            """
            SELECT * FROM posts
            JOIN post_comments ON posts.id = post_comments.post_id
            WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(posts.time) < DATE(NOW())
            GROUP BY posts.id
            ORDER BY COUNT(*) DESC
            """,
            nativeQuery = true )
    Page<PostEntity> findAllPopularPosts( Pageable pageable );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            JOIN post_comments ON posts.id = post_comments.post_id
            WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(posts.time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfPopularPosts();


    // Find by like count
    @Query( value =
            """
            SELECT * FROM posts
            JOIN post_votes ON posts.id = post_votes.post_id
            WHERE value > 0  AND is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(posts.time) < DATE(NOW())
            GROUP BY posts.id
            ORDER BY COUNT(*) DESC
            """,
            nativeQuery = true )
    Page<PostEntity> findAllBestPosts( Pageable pageable );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            JOIN post_votes ON posts.id = post_votes.post_id
            WHERE value > 0  AND is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(posts.time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfBestPosts();
}
