package com.hukuta94.blogengine.dao.tag.repository;

import com.hukuta94.blogengine.dao.tag.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Integer>
{

}
