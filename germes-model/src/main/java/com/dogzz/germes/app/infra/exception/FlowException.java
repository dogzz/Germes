package com.dogzz.germes.app.infra.exception;

import com.dogzz.germes.app.infra.exception.base.AppException;

/**
 * Signals about exceptional cases in the application logic
 * Created by afon on 03.04.2016.
 */
public class FlowException extends AppException{
    private static final long serialVersionUID = -2889607185988464072L;
    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }
    public FlowException(String message) {
        super(message);
    }
}
