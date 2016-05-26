package com.dogzz.germes.app.service.transform.impl;

import com.dogzz.germes.app.infra.util.Checks;
import com.dogzz.germes.app.infra.util.CommonUtil;
import com.dogzz.germes.app.infra.util.ReflectionUtil;
import com.dogzz.germes.app.model.entity.base.AbstractEntity;
import com.dogzz.germes.app.rest.dto.base.BaseDTO;
import com.dogzz.germes.app.service.transform.Transformer;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default transformation engine that uses reflection to transform objects
 * Created by afon on 05.04.2016.
 */
public class SimpleDTOTransformer implements Transformer {

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleDTOTransformer.class);

    private final FieldProvider provider;
    public SimpleDTOTransformer() {
        provider = new CachedFieldProvider();
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(final T entity, final Class<P> clz) {
        checkParams(entity, clz);
        P dto = ReflectionUtil.createInstance(clz);
        ReflectionUtil.copyFields(entity, dto,
                provider.getFieldNames(entity.getClass(), clz));
        dto.transform(entity);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} DTO object", CommonUtil.toString(dto));
        }
        return dto;
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T untransform(P dto, Class<T> clz) {
        checkParams(dto, clz);
        T entity = ReflectionUtil.createInstance(clz);
        ReflectionUtil.copyFields(dto, entity,
                provider.getFieldNames(dto.getClass(), clz));
        dto.untransform(entity);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} entity", CommonUtil.toString(entity));
        }
        return entity;
    }

    private void checkParams(final Object param, final Class<?> clz) {
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clz != null, "No class is defined for transformation");
    }


}
