package com.hukuta94.blog_engine.repository;

import com.hukuta94.blog_engine.model.entity.post.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Integer>
{

}
