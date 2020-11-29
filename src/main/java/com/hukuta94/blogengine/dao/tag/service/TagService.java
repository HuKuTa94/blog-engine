package com.hukuta94.blogengine.dao.tag.service;

import com.hukuta94.blogengine.domain.tag.model.TagResultDto;
import com.hukuta94.blogengine.dao.tag.entity.TagEntity;
import com.hukuta94.blogengine.domain.tag.model.TagDto;
import com.hukuta94.blogengine.dao.post.repository.MultiPostRepository;
import com.hukuta94.blogengine.dao.tag.repository.TagRepository;
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
    private final MultiPostRepository postsOnMainPageRepository;

    public TagResultDto getTags() {
        long postTotalCount = postsOnMainPageRepository.count();

        Iterable<TagEntity> iterable = tagRepository.findAll();
        List<TagDto> tags = new ArrayList<>();
        for ( TagEntity tag : iterable )
        {
            float tagWeight = tag.getPosts().size() / (float) postTotalCount;
            tags.add( new TagDto( tag.getName(), tagWeight ));
        }
        return new TagResultDto( tags );
    }
}
