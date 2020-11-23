package com.hukuta94.blog_engine.api.response;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Response for /api/init GET request. Contains blog info and contacts
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@Component
@ConfigurationProperties( prefix = "blog" )
public class InitResponse
{
    private String title;
    private String subTitle;
    private String phone;
    private String email;
    private String copyright;
    private String copyrightFrom;
}
