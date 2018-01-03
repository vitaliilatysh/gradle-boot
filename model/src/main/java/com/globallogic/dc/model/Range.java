package com.globallogic.dc.model;

import java.util.List;

public class Range {

    private Item item;
    private Range range;
    private List<Section> sections;

    public Range(Item item, Range range, List<Section> sections) {
        this.item = item;
        this.range = range;
        this.sections = sections;
    }

    public Range(List<Section> sections) {
        this.sections = sections;
    }

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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
