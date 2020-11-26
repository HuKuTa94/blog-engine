package com.hukuta94.blog_engine.api.response;

import com.hukuta94.blog_engine.model.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Response for /api/tag GET requests. Contains list of tags.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class TagResponse
{
    private List< TagDto > tags;
}
