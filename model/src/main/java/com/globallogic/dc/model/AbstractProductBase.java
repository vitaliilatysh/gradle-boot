package com.globallogic.dc.model;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.trim;

public abstract class AbstractProductBase {

    private String key;
    private String title;
    private String description;

    public AbstractProductBase(
            final String key,
            final String title,
            final String description) {
        this.key = key;
        this.title = title;
        this.description = description;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public boolean hasKey() {
        return isNotEmpty(trim(this.key));
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return isNotEmpty(trim(this.title));
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        return isNotEmpty(trim(this.description));
    }
}
