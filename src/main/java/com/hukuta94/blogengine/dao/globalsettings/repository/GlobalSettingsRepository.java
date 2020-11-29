package com.hukuta94.blogengine.dao.globalsettings.repository;

import com.hukuta94.blogengine.dao.globalsettings.entity.GlobalSettingsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalSettingsRepository extends CrudRepository<GlobalSettingsEntity, Integer>
{

}
