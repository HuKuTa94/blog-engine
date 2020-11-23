package com.hukuta94.blog_engine.model.tag;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object for processing /api/tag response.
 * This class used by TagResponse to make a list of tags.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class TagDto
{
    private String name;
    private float weight;
}
