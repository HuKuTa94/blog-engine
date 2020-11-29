package com.hukuta94.blogengine.dao.comment.entity;

import com.hukuta94.blogengine.dao.user.entity.UserEntity;
import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Class-entity of comments for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
@Entity
@Table( name = "post_comments" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    /**
     * the comment that this comment was posted to
     * (can be NULL if a comment is left on the post)
     */
    @Nullable
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "parent_id" )
    private CommentEntity parentComment;

    /**
     * the post to which the comment was written
     */
    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "post_id" )
    private PostEntity post;

    /**
     * the author of the comment
     */
    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private UserEntity user;

    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    @NonNull
    @Column( name = "text" )
    private String text;
}
