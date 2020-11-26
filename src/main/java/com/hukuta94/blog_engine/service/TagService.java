package com.hukuta94.blog_engine.service;

import com.hukuta94.blog_engine.api.response.TagResponse;
import com.hukuta94.blog_engine.model.entity.post.TagEntity;
import com.hukuta94.blog_engine.model.dto.TagDto;
import com.hukuta94.blog_engine.repository.PostRepository;
import com.hukuta94.blog_engine.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for processing /api/tag/* requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class TagService
{
    private final TagRepository tagRepository;
    private final PostRepository postRepository;

    public TagResponse getTags() {
        long postTotalCount = postRepository.count();

        Iterable<TagEntity> iterable = tagRepository.findAll();
        List<TagDto> tags = new ArrayList<>();
        for ( TagEntity tag : iterable )
        {
            float tagWeight = tag.getPosts().size() / (float) postTotalCount;
            tags.add( new TagDto( tag.getName(), tagWeight ));
        }
        return new TagResponse( tags );
    }
}
