package com.backend.common.config;

import com.backend.common.filters.CustomHeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TraceIdInterceptor traceIdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceIdInterceptor);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean<CustomHeaderFilter> loggingFilter() {
        FilterRegistrationBean<CustomHeaderFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomHeaderFilter());
        registrationBean.addUrlPatterns("/*"); // Set URL patterns to apply the filter
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

}

