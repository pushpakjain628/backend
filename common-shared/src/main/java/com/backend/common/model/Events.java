package com.backend.common.model;

import io.micrometer.observation.annotation.Observed;

public enum Events {
    GENERAL,
    EXTERNAL_API_REQUEST,
    EXTERNAL_API_RESPONSE,
    CALCULATING_TIME,
    EXTERNAL_API_URL,
  REQUEST,
    RESPONSE
}
