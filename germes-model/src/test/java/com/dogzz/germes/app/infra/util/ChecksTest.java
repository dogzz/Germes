package com.dogzz.germes.app.infra.util;

import com.dogzz.germes.app.infra.exception.flow.InvalidParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by afon on 03.04.2016.
 */
public class ChecksTest {

    @Test
    public void testCheckParameterGetException() {
        try {
            Checks.checkParameter(false, "test");
            assertTrue(false);
        } catch (Exception ex) {
            assertSame(ex.getClass(), InvalidParameterException.class);
            assertEquals(ex.getMessage(), "test");
        }

    }

    @Test
    public void testCheckParameterNoException() {
        Checks.checkParameter(true, "test");
        assertTrue(true);
    }
}