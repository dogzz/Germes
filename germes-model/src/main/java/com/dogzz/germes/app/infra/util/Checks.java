package com.dogzz.germes.app.infra.util;

import com.dogzz.germes.app.infra.exception.flow.InvalidParameterException;

/**
 * Contains common check routines
 * Created by afon on 03.04.2016.
 */
public class Checks {
    private Checks() {}

    /**
     * Verifies that specified check passed and throws exception otherwise
     * @param check
     * @param message
     * @throws InvalidParameterException
     */
    public static void checkParameter (boolean check, String message) throws InvalidParameterException {
        if (!check) {
            throw new InvalidParameterException(message);
        }
    }
}
