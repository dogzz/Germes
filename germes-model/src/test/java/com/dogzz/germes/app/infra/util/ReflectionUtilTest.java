package com.dogzz.germes.app.infra.util;

import com.dogzz.germes.app.infra.exception.ConfigurationException;
import com.dogzz.germes.app.infra.exception.flow.InvalidParameterException;
import com.dogzz.germes.app.infra.util.annotation.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link ReflectionUtil} unit
 * Created by afon on 05.04.2016.
 */
public class ReflectionUtilTest {

    @Test
    public void createInstanceSuccess() {
        Object value = ReflectionUtil.createInstance(Source.class);
        assertNotNull(value);
    }

    @Test(expected = ConfigurationException.class)
    public void createInstanceFailure() {
        ReflectionUtil.createInstance(Restricted.class);
    }

    @Test
    public void findSimilarFieldsSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class,
                Destination.class);
        assertNotNull(fields);
        assertTrue(fields.contains("value"));
    }

    @Test
    public void copyFieldsSuccess() {
        Source src = new Source();
        src.setValue(10);
        Destination dest = new Destination();
        List<String> fields = ReflectionUtil.findSimilarFields(src.getClass(), dest.getClass());

        ReflectionUtil.copyFields(src, dest, fields);
        assertEquals(dest.getValue(), 10);
    }

    @Test(expected=InvalidParameterException.class)
    public void copyFieldsDestinationNullFailure() {
        Source src = new Source();
        ReflectionUtil.copyFields(src, null, Collections.emptyList());
    }

    @Test
    public void copyFindSimilarFieldsWithIgnoreSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("ignored"));
    }

    @Test
    public void copyFindSimilarFieldsForStaticAndFinalSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertFalse(fields.contains("staticField"));
        assertFalse(fields.contains("finalField"));
    }

    @Test
    public void copyFindSimilarFieldsForBaseFieldSuccess() {
        List<String> fields = ReflectionUtil.findSimilarFields(Source.class, Destination.class);
        assertTrue(fields.contains("baseField"));
    }
}

class BaseSource {
    private int baseField;
}

class BaseDestination {
    private int baseField;
}

class Source extends BaseSource {
    private int value;

    private String text;

    @Ignore
    private int ignored = 2;

    private static int staticField;

    private final int finalField = 0;

    public void setValue(int value) {
        this.value = value;
    }
}

class Destination extends BaseDestination {
    private int value;

    private int ignored;

    private int staticField;

    private int finalField = 0;

    public int getValue() {
        return value;
    }
}

class Restricted {
    public Restricted(int value) {

    }

}