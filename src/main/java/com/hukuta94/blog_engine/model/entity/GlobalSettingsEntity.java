package com.hukuta94.blog_engine.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

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

    @NonNull
    @Column( name = "code" )
    private String code;

    @NonNull
    @Column( name = "name" )
    private String name;

    @NonNull
    @Column( name = "value" )
    private String value;
}
