package com.dogzz.germes.app.rest.dto.base;

import com.dogzz.germes.app.model.entity.base.AbstractEntity;

/**
 * Base class for all DTO classes
 * Created by afon on 05.04.2016.
 */
public class BaseDTO<T extends AbstractEntity> {
    private int id;

    public void transform(T t) {
        id = t.getId();
    }

    public T untransform(T t) {
        t.setId(getId());
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
