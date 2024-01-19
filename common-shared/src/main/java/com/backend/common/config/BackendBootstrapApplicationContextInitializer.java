package com.backend.common.config;

import com.backend.common.model.Events;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


public class BackendBootstrapApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (MDC.get("event") == null) {
            MDC.put("event", Events.GENERAL.toString());
        }
    }
}
