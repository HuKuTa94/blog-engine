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
 * @version 1.01
 */

@Service
@Transactional
@AllArgsConstructor
public class TagService
{
    private final TagRepository tagRepository;
    private final MultiPostRepository multiPostRepository;

    public TagResultDto getTags( String query ) {
        float postTotalCount = multiPostRepository.countOfPublishedPosts();
        List<TagEntity> tagEntities = tagRepository.findAll();

        List<TagDto> tags = new ArrayList<>();
        for ( TagEntity tag : tagEntities )
        {
            float postCountWithTag = multiPostRepository.countOfPostsByTag( tag.getName() );
            float tagWeight = (postCountWithTag / postTotalCount) * 2f;
            tags.add( new TagDto( tag.getName(), tagWeight ));
        }
        return new TagResultDto( tags );
    }
}
