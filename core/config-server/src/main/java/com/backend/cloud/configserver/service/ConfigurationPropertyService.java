package com.backend.cloud.configserver.service;

import com.backend.cloud.configserver.entity.ConfigurationProperty;
import com.backend.cloud.configserver.repository.ConfigurationPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ConfigurationPropertyService {

    private final ConfigurationPropertyRepository repository;

    @Autowired
    public ConfigurationPropertyService(ConfigurationPropertyRepository repository) {
        this.repository = repository;
    }

    public List<ConfigurationProperty> getAllProperties() {
        return repository.findAll();
    }

    public ConfigurationProperty saveProperty(ConfigurationProperty property) {
        property.setCreatedOn(new Timestamp(System.currentTimeMillis()));
        return repository.save(property);
    }
}

