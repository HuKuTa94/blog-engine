package com.hukuta94.blogengine.dao.tag.repository;

import com.hukuta94.blogengine.dao.tag.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository of post tags with custom queries.
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.01
 */

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Integer>
{
    @Query( value =
            """
            SELECT DISTINCT t.id, t.name FROM tags AS t
            JOIN posts AS p ON p.is_active = 1 AND p.moderation_status = 'ACCEPTED' AND DATE(p.time) < DATE(NOW())
            JOIN tag2post AS t2p ON t2p.post_id = p.id AND t2p.tag_id = t.id
            """,
            nativeQuery = true )
    List<TagEntity> findAll();
}
