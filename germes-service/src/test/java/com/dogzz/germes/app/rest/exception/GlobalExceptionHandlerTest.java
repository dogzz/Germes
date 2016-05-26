package com.dogzz.germes.app.rest.exception;

import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import static org.junit.Assert.*;

/**
 * Verifies that {@link GlobalExceptionHandler} correctly handles application
 * Created by afon on 08.04.2016.
 */
public class GlobalExceptionHandlerTest {
    /**
     * Current exception handler
     */
    private ExceptionMapper<Exception> handler;

    @Before
    public void setup() {
        handler = new GlobalExceptionHandler();
    }

    @Test
    public void testToResponseReturnServerError() {
        Exception exception = new Exception("test");
        Response response = handler.toResponse(exception);
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

}