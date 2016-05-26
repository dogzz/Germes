package com.dogzz.germes.app.infra.util;

import com.dogzz.germes.app.model.entity.geography.City;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.*;

/**
 * Common utilities
 * Created by afon on 02.04.2016.
 */
public class CommonUtil {

    private CommonUtil() {}

    public static <T> Set<T> getSafeSet(Set<T> source) {
        return Collections.unmodifiableSet(Optional.ofNullable(source).orElse( Collections.emptySet()));
    }

    public static <T> List<T> getSafeList(List<T> source) {
        return Collections.unmodifiableList(Optional.ofNullable(source).orElse( Collections.emptyList() ));
    }

    public static String toString(Object param) {
        return ReflectionToStringBuilder.toString(param,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
