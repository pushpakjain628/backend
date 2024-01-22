package com.backend.cloud.configserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "PROPERTIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfigurationProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATED_ON")
    private Timestamp createdOn;

    @Column(name = "APPLICATION")
    private String application;

    @Column(name = "PROFILE")
    private String profile;

    @Column(name = "LABEL")
    private String label;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;
}



