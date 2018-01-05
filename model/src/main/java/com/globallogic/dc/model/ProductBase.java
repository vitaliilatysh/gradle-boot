package com.globallogic.dc.model;

public abstract class ProductBase {

    private String key;
    private String title;
    private String description;

    public String getKey() {
        return key;
    }
    public void setKey(final String key) {
        this.key = key;
    }
    public boolean hasKey() {
        return this.getKey() != null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public boolean hasTitle() {
        return this.getTitle() != null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean hasDescription() {
        return this.getDescription() != null;
    }




}
