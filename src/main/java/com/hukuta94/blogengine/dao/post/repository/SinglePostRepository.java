package com.hukuta94.blogengine.dao.post.repository;

import com.hukuta94.blogengine.dao.post.entity.PostEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository of the posts with custom queries.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.01
 */

@Repository
public interface SinglePostRepository extends PagingAndSortingRepository<PostEntity, Integer>
{
    // Find by id
    Optional<PostEntity> findById( int id );
}
