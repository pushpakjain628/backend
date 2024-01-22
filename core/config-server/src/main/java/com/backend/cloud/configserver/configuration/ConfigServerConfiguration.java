package com.backend.cloud.configserver.configuration;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.environment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class ConfigServerConfiguration {

    private final DataSource dataSource; // Inject your DataSource bean here
    private final ConfigurableEnvironment environment; // Inject your Environment bean here
    ObservationRegistry observationRegistry = ObservationRegistry.create();


    public ConfigServerConfiguration(DataSource dataSource, ConfigurableEnvironment environment) {
        this.dataSource = dataSource;
        this.environment = environment;
    }
    @Bean
    public JdbcEnvironmentRepository jdbcEnvironmentRepository(JdbcTemplate jdbcTemplate) {
        JdbcEnvironmentProperties jdbcEnvironmentProperties = new JdbcEnvironmentProperties();
        jdbcEnvironmentProperties.setDefaultLabel("test");
        jdbcEnvironmentProperties.setEnabled(true);
        jdbcEnvironmentProperties.setFailOnError(false);
        return new JdbcEnvironmentRepositoryFactory(jdbcTemplate).build(jdbcEnvironmentProperties);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}

