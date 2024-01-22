package com.backend.cloud.configserver.controller;
import com.backend.cloud.configserver.entity.ConfigurationProperty;
import com.backend.cloud.configserver.service.ConfigurationPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigurationPropertyController {

    private final ConfigurationPropertyService service;

    @Autowired
    public ConfigurationPropertyController(ConfigurationPropertyService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConfigurationProperty> getAllProperties() {
        return service.getAllProperties();
    }

    @PostMapping("/add")
    public ConfigurationProperty addProperty(@RequestBody ConfigurationProperty property) {
        return service.saveProperty(property);
    }
}
