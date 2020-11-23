package com.hukuta94.blog_engine.repository;

import com.hukuta94.blog_engine.model.entity.GlobalSettingsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalSettingsRepository extends CrudRepository<GlobalSettingsEntity, Integer>
{

}