package com.globallogic.dc.model;

public abstract class AbstractProduct extends AbstractProductBase {

    public AbstractProduct(
            final String key,
            final String title,
            final String description) {
        super(key, title, description);
    }

    public AbstractProduct() {
    }

    public String getIdentifier() {
        return this.getKey();
    }
}
