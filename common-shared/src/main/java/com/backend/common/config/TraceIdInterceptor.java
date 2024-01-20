package com.backend.common.config;

import com.backend.common.model.Events;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

import static com.backend.common.utility.HttpUtils.getStringValue;

@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor, ClientHttpRequestInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Generate a new traceId for each incoming request

        String requestBody = getStringValue(((ContentCachingRequestWrapper) request).getContentAsByteArray(),
                request.getCharacterEncoding());
        MDC.put("event", Events.REQUEST.name());
        MDC.put("REQUESTPAYLOAD",requestBody);

        log.info(
                "PROCESSING : METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={}",
                request.getMethod(), request.getRequestURI(), requestBody);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        MDC.put("event", Events.RESPONSE.name());
        // Wrap the response to capture the response body
        try {
            String responseBody = getStringValue(((ContentCachingResponseWrapper) response).getContentAsByteArray(),
                    response.getCharacterEncoding());
            MDC.put("RESPONSEPAYLOAD",responseBody);
            log.info(
                    "PROCESSING COMPLETED : METHOD={}; REQUESTURI={}; RESPONSEPAYLOAD={} RESPONSECODE={};",
                    request.getMethod(), request.getRequestURI(), responseBody,response.getStatus());
        } catch (Exception e) {
            log.error("Error logging response body", e);
        } finally {
            // Clear the traceId after processing the request
            MDC.remove("traceId");
            MDC.remove("event");

        }
    }


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Retrieve traceId from MDC
        String traceId = MDC.get("traceId");

        // Add traceId to the HTTP headers
        HttpHeaders headers = request.getHeaders();
        headers.add("traceId", traceId);

        // Continue with the execution of the request
        return execution.execute(request, body);
    }
}

