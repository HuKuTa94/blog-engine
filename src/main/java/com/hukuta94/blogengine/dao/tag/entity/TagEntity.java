package com.hukuta94.blogengine.dao.tag.entity;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * Class-entity of tags for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
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

    /**
     * text of the tag
     */
    @NonNull
    @Column( name = "name" )
    private String name;

    /**
     * posts that using this tag
     */
    @NonNull
    @ManyToMany
    @JoinTable( name="tag2post",
            joinColumns = @JoinColumn( name = "tag_id" ),
            inverseJoinColumns = @JoinColumn( name = "post_id" ))
    private List<PostEntity> posts;


}
