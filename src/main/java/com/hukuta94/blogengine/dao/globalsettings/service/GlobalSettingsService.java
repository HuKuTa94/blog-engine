package com.hukuta94.blogengine.dao.globalsettings.service;

import com.hukuta94.blogengine.dao.globalsettings.entity.GlobalSettingsEntity;
import com.hukuta94.blogengine.dao.globalsettings.repository.GlobalSettingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Service for processing global blog settings requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

@Service
@Transactional
@AllArgsConstructor
public class GlobalSettingsService
{
    private final GlobalSettingsRepository repository;

    public Map<String, Boolean> getSettings() {
        Iterable<GlobalSettingsEntity> iterable = repository.findAll();
        Map<String, Boolean> response = new HashMap<>();
        for ( GlobalSettingsEntity setting : iterable ) {
            response.put( setting.getCode(), setting.getValue().equals( "YES" ));
        }
        return response;
    }
}
