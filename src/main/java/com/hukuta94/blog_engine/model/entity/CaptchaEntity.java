package com.hukuta94.blog_engine.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table( name = "captcha_codes" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaEntity
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @NonNull
    @Column( name = "id" )
    private int id;

    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    @NonNull
    @Column( name = "code" )
    private String code;

    @NonNull
    @Column( name = "secret_code" )
    private String secretCode;
}
