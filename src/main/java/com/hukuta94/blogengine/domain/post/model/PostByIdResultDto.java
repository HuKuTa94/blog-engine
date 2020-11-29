package com.hukuta94.blogengine.domain.post.model;

import com.hukuta94.blogengine.domain.comment.model.CommentDto;
import com.hukuta94.blogengine.domain.user.model.UserWithoutPhotoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response for /api/post/{ID} requests. Contains post's info with comments, votes, tags and author.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
public class PostByIdResultDto
{
    private int id;
    private long timestamp;
    private boolean active;
    private UserWithoutPhotoDto user;
    private String title;
    private String text;
    private long likeCount;
    private long dislikeCount;
    private long viewCount;
    private List<String> tags;
    private List<CommentDto> comments;
}
