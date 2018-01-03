package com.globallogic.dc.model;

public class Chapter {

    private SubChapter subChapter;

    public Chapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }

    public SubChapter getSubChapter() {
        return subChapter;
    }

    public void setSubChapter(SubChapter subChapter) {
        this.subChapter = subChapter;
    }
}
