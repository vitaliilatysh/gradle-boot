package com.globallogic.dc.model;

public abstract class AbstractProductBase {

    private String key;
    private String title;
    private String description;

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public boolean hasKey() {
        return this.key != null;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return this.title != null;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        return this.description != null;
    }
}
