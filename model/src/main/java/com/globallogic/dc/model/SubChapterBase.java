package com.globallogic.dc.model;

import java.util.Collection;
import java.util.List;

public abstract class SubChapterBase extends Product {

    private Chapter chapter;
    private List<Section> sections;
    private List<Range> ranges;


    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(final Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(final List<Section> sections) {
        this.sections = sections;
    }

    public List<Range> getRanges() {
        return ranges;
    }

    public void setRanges(final List<Range> ranges) {
        this.ranges = ranges;
    }

    public void addSections(Collection<Section> sections){
        this.sections.addAll(sections);
    }

    public void addSection(Section section){
        this.sections.add(section);
    }

    public void addRanges(Collection<Range> ranges){
        this.ranges.addAll(ranges);
    }

    public void addRange(Range range){
        this.ranges.add(range);
    }

}