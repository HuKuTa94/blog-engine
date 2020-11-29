package com.hukuta94.blogengine.dao.post.service;

import com.hukuta94.blogengine.dao.comment.entity.CommentEntity;
import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import com.hukuta94.blogengine.dao.post.repository.SinglePostRepository;
import com.hukuta94.blogengine.dao.tag.entity.TagEntity;
import com.hukuta94.blogengine.dao.user.entity.UserEntity;
import com.hukuta94.blogengine.dao.util.LocalDateTimeToLongConverter;
import com.hukuta94.blogengine.dao.vote.entity.VoteEntity;
import com.hukuta94.blogengine.domain.comment.model.CommentDto;
import com.hukuta94.blogengine.domain.post.model.PostByIdResultDto;
import com.hukuta94.blogengine.domain.user.model.UserWithPhotoDto;
import com.hukuta94.blogengine.domain.user.model.UserWithoutPhotoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Single-post service for processing /api/post/* requests.
 * Service returns only one found the post and builds the response object.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class SinglePostService extends PostService
{
    private SinglePostRepository repository;


    public ResponseEntity<PostByIdResultDto> getPostById( int id )
    {
        Optional<PostEntity> optional = repository.findById( id );
        if ( optional.isEmpty() ) {
            return ResponseEntity.notFound().build();
        }

        // Get post from optional and create dto
        PostEntity post = optional.get();
        PostByIdResultDto postDto = new PostByIdResultDto();

        //Get post id
        postDto.setId( post.getId() );

        // Get time in long
        long timestamp = LocalDateTimeToLongConverter.toMinutes( post.getTime() );
        postDto.setTimestamp( timestamp );

        // Get "active" property
        postDto.setActive( post.getIsActive() == 1 );

        // Get author of the post
        UserEntity user = post.getUser();
        postDto.setUser( new UserWithoutPhotoDto( user.getId(), user.getName() ));

        // Get title and text
        postDto.setTitle( post.getTitle() );
        postDto.setText( post.getText() );

        // Get all likes and dislikes
        Collection<VoteEntity> votes = post.getVotes();
        postDto.setLikeCount( getLikeCount( votes ));
        postDto.setDislikeCount( getDislikeCount( votes ));

        // Get view count
        postDto.setViewCount( post.getViewCount() );

        // Get tags
        List<TagEntity> tagEntities = post.getTags();
        List<String> tags = new ArrayList<>( tagEntities.size() );
        for ( TagEntity tag : tagEntities) {
            tags.add( tag.getName() );
        }
        postDto.setTags( tags );

        // Get Comments
        List<CommentEntity> commentEntities = post.getComments();
        List<CommentDto> comments = new ArrayList<>( commentEntities.size() );
        for ( CommentEntity commentEntity : commentEntities )
        {
            CommentDto commentDto = new CommentDto();
            commentDto.setId( commentEntity.getId() );
            commentDto.setTimestamp( LocalDateTimeToLongConverter.toMinutes( commentEntity.getTime() ));
            commentDto.setText( commentEntity.getText() );

            // Get author of comment
            UserEntity userEntity = commentEntity.getUser();
            commentDto.setUser(
                    new UserWithPhotoDto(
                        userEntity.getId(),
                        userEntity.getName(),
                        userEntity.getPhoto()
                    )
            );

            comments.add( commentDto );
        }
        postDto.setComments( comments );

        return ResponseEntity.ok( postDto );
    }
}
