package com.backend.common.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.backend.*"})
public @interface BackendBootstrapApplication {
    Class<?>[] scanBasePackageClasses() default {};

    Class<? extends ApplicationContextInitializer<?>>[] contextInitializerClasses() default {BackendBootstrapApplicationContextInitializer.class};
}
