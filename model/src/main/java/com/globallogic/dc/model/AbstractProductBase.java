package com.globallogic.dc.model;

import com.globallogic.dc.commons.model.Entity;
import io.swagger.annotations.ApiModelProperty;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public abstract class AbstractProductBase extends Entity<String> {

    @ApiModelProperty(required = true)
    private String key;

    @ApiModelProperty(required = true)
    private String title;

    @ApiModelProperty(required = true)
    private String description;

    public AbstractProductBase(
            final String key,
            final String title,
            final String description) {
        this.key = key;
        this.title = title;
        this.description = description;
    }

    public AbstractProductBase() {
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public boolean hasKey() {
        return isNotBlank(this.key);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return isNotBlank(this.title);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        return isNotBlank(this.description);
    }
}
