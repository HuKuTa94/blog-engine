package com.hukuta94.blog_engine.repository;

import com.hukuta94.blog_engine.model.entity.post.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer>
{

}
