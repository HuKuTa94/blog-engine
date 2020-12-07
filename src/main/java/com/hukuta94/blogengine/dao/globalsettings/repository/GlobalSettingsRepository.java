package com.hukuta94.blogengine.dao.globalsettings.repository;

import com.hukuta94.blogengine.dao.globalsettings.entity.GlobalSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalSettingsRepository extends JpaRepository<GlobalSettingsEntity, Integer>
{
    List<GlobalSettingsEntity> findAll();
}
