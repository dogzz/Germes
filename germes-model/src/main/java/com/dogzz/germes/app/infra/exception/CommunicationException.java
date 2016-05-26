package com.dogzz.germes.app.infra.exception;

import com.dogzz.germes.app.infra.exception.base.AppException;

/**
 * Signals about exception cases in the work of external services and API
 * Created by afon on 03.04.2016.
 */
public class CommunicationException extends AppException {

    private static final long serialVersionUID = -2850898723336164866L;

    public CommunicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommunicationException(String message) {
        super(message);
    }
}
