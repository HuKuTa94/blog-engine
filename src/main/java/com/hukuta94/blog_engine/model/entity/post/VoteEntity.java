package com.hukuta94.blog_engine.model.entity.post;

import com.hukuta94.blog_engine.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Class-entity of likes / dislikes for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
@Entity
@Table( name = "post_votes" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    /**
     * the user who put a like / dislike
     */
    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private UserEntity user;

    /**
     * post that has been liked / disliked
     */
    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "post_id" )
    private PostEntity post;

    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    /**
     * like or dislike: 1 or -1
     */
    @NonNull
    @Column( name = "value" )
    private byte value;

}
