package com.hukuta94.blog_engine.model.entity.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    @NonNull
    @Column( name = "name" )
    private String name;

    @NonNull
    @ManyToMany
    @JoinTable( name="tag2post",
            joinColumns = @JoinColumn( name = "tag_id" ),
            inverseJoinColumns = @JoinColumn( name = "post_id" ))
    private List<PostEntity> posts;


}
