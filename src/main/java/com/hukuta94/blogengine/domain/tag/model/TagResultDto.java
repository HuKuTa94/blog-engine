package com.hukuta94.blogengine.domain.tag.model;

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
public class TagResultDto
{
    private List<TagDto> tags;
}
