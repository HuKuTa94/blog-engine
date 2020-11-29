package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import com.hukuta94.blogengine.dao.post.repository.PostOnMainPageRepository;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageResultDto;
import com.hukuta94.blogengine.domain.post.model.PostOnMainPageDto;
import com.hukuta94.blogengine.domain.user.model.UserWithoutPhotoDto;
import com.hukuta94.blogengine.dao.user.entity.UserEntity;
import com.hukuta94.blogengine.dao.vote.entity.VoteEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.transaction.Transactional;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Service for processing /api/post/* requests. Service does SQL requests to the database and builds response object.
 * Response object "PostResponse" contains a count of posts and list of all found posts by API request
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class PostOnMainPageService
{
    private static final int ANNOUNCE_TEXT_LENGTH = 200;
    private PostOnMainPageRepository repository;


    public ResponseEntity<PostOnMainPageResultDto> getSortedPostsWithOffsetAndLimit( int offset, int limit, String mode ) {
        int pageIndex = offset / limit;
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

        return ResponseEntity.ok( createResultDto( pages, countOfPosts ));
    }

    public Optional<PostEntity> getPostById( int id ) {
        return repository.findById( id );
    }

    private Page<PostEntity> getPostsSortedByDate( int pageIndex, int limit, Sort.Direction direction ) {
        String sortField = "time";
        Pageable pageable = PageRequest.of( pageIndex, limit, direction, sortField );
        return repository.findAllPostsByDate( pageable );
    }

    private Page<PostEntity> getPopularPosts( int pageIndex, int limit ) {
        Pageable pageable = PageRequest.of( pageIndex, limit );
        return repository.findAllPopularPosts( pageable );
    }

    private Page<PostEntity> getBestPosts( int pageIndex, int limit ) {
        Pageable pageable = PageRequest.of( pageIndex, limit );
        return repository.findAllBestPosts( pageable );
    }

    private PostOnMainPageResultDto createResultDto( Page<PostEntity> pages, long countOfPosts ) {
        List<PostOnMainPageDto> postList = new ArrayList<>();
        for ( PostEntity post : pages )
        {
            // Get all likes and dislikes
            Collection<VoteEntity> votes = post.getVotes();

            long likeCount = votes.stream()
                    .filter( vote -> vote.getValue() > 0 )
                    .count();

            long dislikeCount = votes.stream()
                    .filter( vote -> vote.getValue() < 0 )
                    .count();

            // Fill all dto fields
            PostOnMainPageDto postDto = new PostOnMainPageDto();
            postDto.setId( post.getId() );

            // Get timestamp in seconds
            long timestamp = post.getTime()
                    .atZone( ZoneId.of( "UTC" ))
                    .toInstant()
                    .toEpochMilli() / 1000;
            postDto.setTimestamp( timestamp);

            //  Post's text
            postDto.setTitle( post.getTitle() );
            String text = HtmlUtils.htmlEscape( post.getText() ); // remove HTML tags

            // Cut text length and add dots at end
            if ( text.length() > ANNOUNCE_TEXT_LENGTH ) {
                text = text.substring( 0, ANNOUNCE_TEXT_LENGTH ) + "...";
            }
            postDto.setAnnounce( text );

            // Discussing and votes
            postDto.setLikeCount( likeCount );
            postDto.setDislikeCount( dislikeCount );
            postDto.setCommentCount( post.getComments().size() );
            postDto.setViewCount( post.getViewCount() );

            UserEntity user = post.getUser();
            postDto.setUser( new UserWithoutPhotoDto( user.getId(), user.getName() ));

            // Add dto to result list
            postList.add(postDto);
        }

        // Total post count equals 0 if posts weren't found by request
        if ( postList.isEmpty() ) {
            countOfPosts = 0;
        }
        return new PostOnMainPageResultDto( countOfPosts, postList );
    }
}
