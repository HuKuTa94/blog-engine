package com.hukuta94.blogengine.dao.user.entity;

import com.hukuta94.blogengine.dao.vote.entity.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Class-entity of user for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
@Entity
@Table( name = "users" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    @NonNull
    @Column( name = "is_moderator" )
    private int isModerator;

    @NonNull
    @Column( name = "reg_time" )
    private LocalDateTime registrationDate;

    @NonNull
    @Column( name = "name" )
    private String name;

    @NonNull
    @Column( name = "email" )
    private String email;

    @NonNull
    @Column( name = "password" )
    private String password;

    /**
     * password reset code, can be NULL
     */
    @Nullable
    @Column( name = "code" )
    private String code;

    @Nullable
    @Column( name = "photo" )
    private String photo;

    /**
     * user's likes/dislikes
     */
    @OneToMany( mappedBy = "user", fetch = FetchType.LAZY )
    private Collection<VoteEntity> votes;
}