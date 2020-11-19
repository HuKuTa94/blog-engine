package com.hukuta94.blog_engine.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Class-entity of captcha codes for the table in the database
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */
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

    /**
     * date and time when the captcha code was generated
     */
    @NonNull
    @Column( name = "time" )
    private LocalDateTime time;

    /**
     * code that is displayed on the captcha image
     */
    @NonNull
    @Column( name = "code" )
    private String code;

    /**
     * code that is passed in the parameter
     */
    @NonNull
    @Column( name = "secret_code" )
    private String secretCode;
}
