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
 * @version 1.03
 */

@Repository
public interface MultiPostRepository extends PagingAndSortingRepository<PostEntity, Integer>
{
    // Count of all published posts
    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfPublishedPosts();


    // Find by all dates
    @Query( value = "SELECT * FROM posts WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())",
            nativeQuery = true )
    Page<PostEntity> findAllSortedPostsByAllDates( Pageable pageable );


    // Find by one date
    @Query( value = "SELECT * FROM posts WHERE is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) = :date",
            nativeQuery = true )
    Page<PostEntity> findAllSortedPostsByOneDate( Pageable pageable, @Param( "date" ) String date );


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
    Page<PostEntity> findAllSortedPostsByComments(Pageable pageable );


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
    Page<PostEntity> findAllSortedPostsByLikes(Pageable pageable );


    // Find all post by tag
    @Query( value =
            """
            SELECT * FROM posts AS p
            JOIN tags
            JOIN tag2post ON tag2post.post_id = p.id AND tag2post.tag_id = tags.id AND tags.name = :tagName
            WHERE p.is_active = 1 AND p.moderation_status = 'ACCEPTED' AND DATE(p.time) < DATE(NOW())
            """,
            nativeQuery = true )
    Page<PostEntity> findAllPostsByTag( Pageable pageable, @Param( "tagName" ) String tagName );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts AS p
            JOIN tags
            JOIN tag2post ON tag2post.post_id = p.id AND tag2post.tag_id = tags.id AND tags.name = :tagName
            WHERE p.is_active = 1 AND p.moderation_status = 'ACCEPTED' AND DATE(p.time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfPostsByTag( @Param( "tagName" ) String tagName );


    // Find all posts using search query
    @Query( value =
            """
            SELECT * FROM posts
            WHERE MATCH(title,text) AGAINST(:query) AND is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())
            """,
            nativeQuery = true )
    Page<PostEntity> findAllPostsBySearchQuery( Pageable pageable, @Param( "query") String query );

    @Query( value =
            """
            SELECT COUNT(*) FROM posts
            WHERE MATCH(title,text) AGAINST(:query) AND is_active = 1 AND moderation_status = 'ACCEPTED' AND DATE(time) < DATE(NOW())
            """,
            nativeQuery = true )
    long countOfPostsBySearchQuery( @Param( "query") String query );
}
