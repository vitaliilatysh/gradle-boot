package com.globallogic.dc.model;

public class Range {

    private Item item;
    private Range range;
    private Section sections;

    public Range(Item item, Range range) {
        this.item = item;
        this.range = range;
    }

    public Range(Item item) {
        this.item = item;
    }

    public Range(Range range) {
        this.range = range;
    }

    public Section getSections() {
        return sections;
    }

    public void setSections(Section sections) {
        this.sections = sections;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
