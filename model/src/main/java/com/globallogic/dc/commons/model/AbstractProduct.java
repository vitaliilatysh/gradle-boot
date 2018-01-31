package com.globallogic.dc.commons.model;

public abstract class AbstractProduct extends AbstractProductBase {

    public AbstractProduct(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public String getIdentifier() {
        return this.getKey();
    }
}
