package com.hukuta94.blog_engine.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object for processing /api/post response.
 * This class used by PostDto to make user info.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
public
class UserDto
{
    private int id;
    private String name;
}
