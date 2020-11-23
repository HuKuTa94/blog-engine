package com.hukuta94.blog_engine.api.response;

import com.hukuta94.blog_engine.model.tag.TagDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Response for /api/tag GET requests. Contains list of tags.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@Component
@AllArgsConstructor
public class TagResponse
{
    private List< TagDto > tags;
}
