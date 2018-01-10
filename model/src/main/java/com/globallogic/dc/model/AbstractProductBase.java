package com.globallogic.dc.model;

public abstract class AbstractProductBase {

    private String key;
    private String title;
    private String description;

    public AbstractProductBase(final String key, final String title, final String description) {
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
        return (this.key != null) && !(this.key.trim().isEmpty());
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return (this.title != null) && !(this.title.trim().isEmpty());
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        return (this.description != null) && !(this.description.trim().isEmpty());
    }
}
