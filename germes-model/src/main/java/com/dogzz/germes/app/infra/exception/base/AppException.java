package com.dogzz.germes.app.infra.exception.base;

/**
 * Base class for all application-specific exceptions
 * Created by afon on 03.04.2016.
 */
public class AppException extends RuntimeException {
    private static final long serialVersionUID = 7837501112802868980L;
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable throwable) {
        super(throwable);
    }
}
