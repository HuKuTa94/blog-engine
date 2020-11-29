package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import com.hukuta94.blogengine.dao.post.repository.MultiPostRepository;
import com.hukuta94.blogengine.dao.user.entity.UserEntity;
import com.hukuta94.blogengine.dao.util.LocalDateTimeToLongConverter;
import com.hukuta94.blogengine.dao.vote.entity.VoteEntity;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageDto;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageResultDto;
import com.hukuta94.blogengine.domain.user.model.UserWithoutPhotoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Multi-post service for processing /api/post/* requests.
 * Service return list of posts and builds response object.
 * Response object contains a count of posts and list of all found posts by API request
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class MultiPostService extends PostService
{
    private static final int ANNOUNCE_TEXT_LENGTH = 200;
    private MultiPostRepository repository;


    /** Find all posts by the sorting mode passed in the parameters
     * @param offset - offset from 0 for paginated displaying
     * @param limit - number of posts to display
     * @param mode - sort by recent, early, popular, best
     * @return list of posts
     */
    public ResponseEntity<PostOnMainPageResultDto> getPostsSortedByMode( int offset, int limit, String mode ) {
        int pageIndex = getPageIndex( offset, limit );

        long countOfPosts;
        Page<PostEntity> pages;

        switch( mode ) {
            case "recent":
                pages = getPostsSortedByDate( pageIndex, limit, Sort.Direction.DESC );
                countOfPosts = repository.countOfPostsByDate();
                break;
            case "early":
                pages = getPostsSortedByDate( pageIndex, limit, Sort.Direction.ASC );
                countOfPosts = repository.countOfPostsByDate();
                break;
            case "popular":
                pages = getPopularPosts( pageIndex, limit );
                countOfPosts = repository.countOfPopularPosts();
                break;
            case "best":
                pages = getBestPosts( pageIndex, limit );
                countOfPosts = repository.countOfBestPosts();
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        // Total post count equals 0 if posts weren't found by request
        if( countOfPosts == 0 ) {
            return ResponseEntity.ok( new PostOnMainPageResultDto());
        }

        return ResponseEntity.ok( buildResultDto( pages, countOfPosts ));
    }

    private Page<PostEntity> getPostsSortedByDate( int pageIndex, int limit, Sort.Direction direction ) {
        String sortField = "time";
        Pageable pageable = PageRequest.of( pageIndex, limit, direction, sortField );
        return repository.findAllSortedPostsByDate( pageable );
    }

    private Page<PostEntity> getPopularPosts( int pageIndex, int limit ) {
        Pageable pageable = PageRequest.of( pageIndex, limit );
        return repository.findAllPopularPosts( pageable );
    }

    private Page<PostEntity> getBestPosts( int pageIndex, int limit ) {
        Pageable pageable = PageRequest.of( pageIndex, limit );
        return repository.findAllBestPosts( pageable );
    }

    /**
     * Find all posts by tag passed in the parameters
     * @param offset - offset from 0 for paginated displaying
     * @param limit - number of posts to display
     * @param tag - tag name
     * @return list of posts
     */
    public ResponseEntity<PostOnMainPageResultDto> getPostsByTag( int offset, int limit, String tag ) {
        long countOfPosts = repository.countOfPostsByTag( tag );

        // Total post count equals 0 if posts weren't found by request
        if( countOfPosts == 0 ) {
            return ResponseEntity.ok( new PostOnMainPageResultDto());
        }

        int pageIndex = getPageIndex( offset, limit );
        Pageable pageable = PageRequest.of( pageIndex, limit );
        Page<PostEntity> pages = repository.findAllPostsByTag( pageable, tag );

        return ResponseEntity.ok( buildResultDto( pages, countOfPosts ));
    }

    private PostOnMainPageResultDto buildResultDto( Page<PostEntity> pages, long countOfPosts ) {
        List<PostOnMainPageDto> postList = new ArrayList<>();
        for ( PostEntity post : pages )
        {
            // Fill all dto fields
            PostOnMainPageDto postDto = new PostOnMainPageDto();
            postDto.setId( post.getId() );

            // Get timestamp in seconds
            long timestamp = LocalDateTimeToLongConverter.toMinutes( post.getTime() );

            //  Post's text
            postDto.setTitle( post.getTitle() );
            String text = HtmlUtils.htmlEscape( post.getText() ); // remove HTML tags

            // Cut text length and add dots at end
            if ( text.length() > ANNOUNCE_TEXT_LENGTH ) {
                text = text.substring( 0, ANNOUNCE_TEXT_LENGTH ) + "...";
            }
            postDto.setAnnounce( text );

            // Get all likes and dislikes
            Collection<VoteEntity> votes = post.getVotes();
            postDto.setLikeCount( getLikeCount( votes ));
            postDto.setDislikeCount( getDislikeCount( votes ));

            // Discussing and votes
            postDto.setCommentCount( post.getComments().size() );
            postDto.setViewCount( post.getViewCount() );

            UserEntity user = post.getUser();
            postDto.setUser( new UserWithoutPhotoDto( user.getId(), user.getName() ));

            // Add dto to result list
            postList.add(postDto);
        }

        return new PostOnMainPageResultDto( countOfPosts, postList );
    }
}
