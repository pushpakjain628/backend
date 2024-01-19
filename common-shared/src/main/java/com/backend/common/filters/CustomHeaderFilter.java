package com.backend.common.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.UUID;

@Configuration
@Slf4j
public class CustomHeaderFilter  extends OncePerRequestFilter  {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = response;
        // Check if the header has already been set
        String traceId;

        if (httpServletResponse.getHeader("x-trace-id") == null) {
             traceId = UUID.randomUUID().toString();
        }else{
             traceId = httpServletResponse.getHeader("x-trace-id");
        }

        MDC.put("traceId", traceId);
        httpServletResponse.addHeader("x-trace-id", traceId);

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(httpServletResponse);
        // Continue with the filter chain
        filterChain.doFilter(requestWrapper, responseWrapper);

        responseWrapper.copyBodyToResponse();
        MDC.clear();
    }


}
