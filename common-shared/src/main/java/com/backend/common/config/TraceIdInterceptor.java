package com.backend.common.config;

import com.backend.common.model.Events;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

import static com.backend.common.utility.HttpUtils.getStringValue;

@Component
@Slf4j
public class TraceIdInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Generate a new traceId for each incoming request
        String requestBody = "";
        if (request instanceof ContentCachingRequestWrapper) {
            requestBody = getStringValue(((ContentCachingRequestWrapper) request).getContentAsByteArray() ,
                    request.getCharacterEncoding());
        }else {
            System.out.println(request);
        }

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
            String responseBody = "";
            if (request instanceof ContentCachingRequestWrapper) {
                 responseBody = getStringValue(((ContentCachingResponseWrapper) response).getContentAsByteArray(),
                        response.getCharacterEncoding());
            }

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


}

