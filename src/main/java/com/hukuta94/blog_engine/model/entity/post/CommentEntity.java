package com.hukuta94.blog_engine.model.entity.post;

import com.hukuta94.blog_engine.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Nullable
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "parent_id" )
    private CommentEntity parentComment;

    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "post_id" )
    private PostEntity post;

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
