package com.hukuta94.blogengine.dao.post.repository;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository of multi-posts results with custom queries.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Repository
public interface MultiPostRepository extends PagingAndSortingRepository<PostEntity, Integer>
{
    // Find by date
    @Query( value = "SELECT * FROM posts WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())",
            nativeQuery = true )
    Page<PostEntity> findAllSortedPostsByDate( Pageable pageable );

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


    // Find all post by tag
    @Query( value =
            """
            SELECT * FROM posts
            INNER JOIN tags
            INNER JOIN tag2post ON tag2post.post_id = posts.id AND tag2post.tag_id = tags.id AND tags.name = :tagName
            """,
            nativeQuery = true )
    Page<PostEntity> findAllPostsByTag( Pageable pageable, @Param( "tagName" ) String tagName );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            INNER JOIN tags
            INNER JOIN tag2post ON tag2post.post_id = posts.id AND tag2post.tag_id = tags.id AND tags.name = :tagName
            """,
            nativeQuery = true )
    long countOfPostsByTag( @Param( "tagName" ) String tagName );
}
