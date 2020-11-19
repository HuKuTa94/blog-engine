package com.hukuta94.blog_engine.model.entity.post;

import com.hukuta94.blog_engine.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "user_id" )
    private UserEntity user;

    @NonNull
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "post_id" )
    private PostEntity post;

    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    @NonNull
    @Column( name = "value" )
    private byte value;

}
