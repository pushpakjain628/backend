package com.backend.common.annotations;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootApplication
@ComponentScan(basePackages = {"com.backend.common.*"})
public @interface CustomSpringBootApplication {
}
