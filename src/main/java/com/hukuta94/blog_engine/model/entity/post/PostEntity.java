package com.hukuta94.blog_engine.model.entity.post;

import com.hukuta94.blog_engine.model.ModerationStatus;
import com.hukuta94.blog_engine.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table( name = "posts" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    @NonNull
    @Column( name = "is_active" )
    private int isActive;

    @NonNull
    @Enumerated( EnumType.STRING )
    @Column( name = "moderation_status" )
    private ModerationStatus moderationStatus = ModerationStatus.NEW;

    @Column( name = "moderator_id" )
    private int moderatorId;

    @NonNull
    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinColumn( name = " user_id" )
    private UserEntity user;

    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    @NonNull
    @Column( name = "title" )
    private String title;

    @NonNull
    @Column( name = "text" )
    private String text;

    @NonNull
    @Column( name = "view_count" )
    private int viewCount;

    @ManyToMany
    @JoinTable( name="tag2post",
            joinColumns = @JoinColumn( name = "post_id" ),
            inverseJoinColumns = @JoinColumn( name = "tag_id" ))
    private List<TagEntity> tags;

    @OneToMany( mappedBy = "post", fetch = FetchType.LAZY )
    private Collection<VoteEntity> votes;
}
