package com.hukuta94.blogengine.domain.post.model;

import com.hukuta94.blogengine.domain.user.model.UserWithoutPhotoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for processing /api/post?offset=X&limit=Y&mode=Z response.
 * Used by PostOnMainPageResultDto to build response.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class PostOnMainPageDto {
    private int id;
    private long timestamp;
    private String title;
    private String announce;
    private long likeCount;
    private long dislikeCount;
    private long commentCount;
    private long viewCount;
    private UserWithoutPhotoDto user;
}


