package com.hukuta94.blog_engine.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/**
 * Class-entity of global settings for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
@Entity
@Table( name = "global_settings" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalSettingsEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    /**
     * setting's code:
     * MULTIUSER_MODE,
     * POST_PREMODERATION,
     * STATISTICS_IS_PUBLIC
     */
    @NonNull
    @Column( name = "code" )
    private String code;

    /**
     * description of the code
     */
    @NonNull
    @Column( name = "name" )
    private String name;

    /**
     * setting's value:
     * YES / NO
     */
    @NonNull
    @Column( name = "value" )
    private String value;
}
