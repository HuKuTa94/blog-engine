package com.hukuta94.blogengine.domain.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.TreeMap;

/**
 * Response for /api/calendar request. Contains count of posts  for the years.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCountByYearResultDto
{
    private List<Integer> years;

    /**
     * Count of posts (Integer) in year (String)
     */
    private TreeMap<String, Integer> posts;
}
