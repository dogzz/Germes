package com.dogzz.germes.app.infra.exception;

import com.dogzz.germes.app.infra.exception.base.AppException;

/**
 * Signals about data access layer unexpected situations
 * Created by afon on 03.04.2016.
 */
public class PersistenceException extends AppException {

    private static final long serialVersionUID = -7889716045779735512L;

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(String message) {
        super(message);
    }
}
