package com.dogzz.germes.app.infra.exception;

import com.dogzz.germes.app.infra.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 * Created by afon on 03.04.2016.
 */
public class ConfigurationException extends AppException {

    private static final long serialVersionUID = -2177284893894040026L;

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }
}
