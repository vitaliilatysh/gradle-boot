package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class ItemBase extends ProductBase {

    private Range range;
    private List<Item> items;
    private List<Item> relatedItems;

    public List<Item> getRelatedItems() {
        return relatedItems;
    }

    public void setRelatedItems(List<Item> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(final Range range) {
        this.range = range;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItems(final Collection<Item> items){
        this.items.addAll(items);
    }

    public void addItem(final Item item){
        this.items.add(item);
    }

    public void addRelatedItems(final Collection<Item> relatedItems){
        this.relatedItems.addAll(relatedItems);
    }

    public void addRelatedItem(final Item relatedItem){
        this.relatedItems.add(relatedItem);
    }

}