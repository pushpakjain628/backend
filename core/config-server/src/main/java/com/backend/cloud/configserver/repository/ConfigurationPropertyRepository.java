package com.backend.cloud.configserver.repository;


import com.backend.cloud.configserver.entity.ConfigurationProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationPropertyRepository extends JpaRepository<ConfigurationProperty, Long> {
}

