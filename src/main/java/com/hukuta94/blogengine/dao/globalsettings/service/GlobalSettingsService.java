package com.hukuta94.blogengine.dao.globalsettings.service;

import com.hukuta94.blogengine.dao.globalsettings.entity.GlobalSettingsEntity;
import com.hukuta94.blogengine.dao.globalsettings.repository.GlobalSettingsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service for processing global blog settings requests
 * @autor Nikita Koshelev aka HuKuTa94
 * @version 1.01
 */

@Service
@Transactional
@AllArgsConstructor
public class GlobalSettingsService
{
    private final GlobalSettingsRepository repository;

    public Map<String, Boolean> getSettings() {
        return repository.findAll()
                .stream()
                .collect( Collectors.toMap(
                        GlobalSettingsEntity::getCode,
                        (s) -> s.getValue().equals( "YES" ) ));
    }
}
