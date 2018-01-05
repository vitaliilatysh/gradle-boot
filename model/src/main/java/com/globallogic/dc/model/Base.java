package com.globallogic.dc.model;

public abstract class Base {

    private String key;
    private String title;
    private String description;

    abstract public boolean hasKey();

    abstract public boolean hasTitle();

    abstract public boolean hasDescription();

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
