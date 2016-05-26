package com.dogzz.germes.app.infra.exception.flow;

import com.dogzz.germes.app.infra.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 * Created by afon on 03.04.2016.
 */
public class InvalidParameterException extends FlowException {
    private static final long serialVersionUID = 4990959228756992926L;
    public InvalidParameterException(String message) {
        super(message);
    }
}
