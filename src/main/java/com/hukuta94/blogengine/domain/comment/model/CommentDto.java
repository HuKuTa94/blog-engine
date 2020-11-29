package com.hukuta94.blogengine.domain.comment.model;

import com.hukuta94.blogengine.domain.user.model.UserWithPhotoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for processing /api/post response.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class CommentDto
{
    private int id;
    private long timestamp;
    private String text;
    private UserWithPhotoDto user;
}
