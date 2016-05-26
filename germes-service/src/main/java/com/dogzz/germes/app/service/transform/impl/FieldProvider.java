package com.dogzz.germes.app.service.transform.impl;

import com.dogzz.germes.app.infra.util.ReflectionUtil;

import java.util.List;

/**
 * Base functionality of the field preparation
 * Created by afon on 08.04.2016.
 */
public class FieldProvider {
    public List<String> getFieldNames(Class<?> source, Class<?> dest) {
        return ReflectionUtil.findSimilarFields(source, dest);
    }
}
