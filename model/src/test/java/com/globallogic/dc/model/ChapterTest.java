package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChapterTest {

    private Chapter target;
    private SubChapter subChapter;
    private List<SubChapter> subChapters;

    @Before
    public void initSubChapter() {
        subChapters = new ArrayList<>();
        subChapter = new SubChapter("11", "SubChapTitle11", "SubChapDesc11");
        subChapters.add(subChapter);
    }

    @Before
    public void init() {
        target = new Chapter("1", "Title", "Desc", subChapters) {
        };
    }

    @Test
    public void hasSubChapters() {
        assertTrue(target.hasSubChapters());

        subChapters.remove(subChapter);
        assertFalse(target.hasSubChapters());

        target.setSubChapters(null);
        assertFalse(target.hasSubChapters());

        target = new Chapter("2", "Title2", "Desc2") {
        };
        assertFalse(target.hasSubChapters());
    }

    @Test
    public void addSubChapters() {
        target.addSubChapters(subChapters);
        assertThat(target.getSubChapters().size(), is(2));

        target.addSubChapters(null);
        assertThat(target.getSubChapters().size(), is (2));

        subChapters.clear();
        target.addSubChapters(subChapters);
        assertThat(target.getSubChapters().size(), is (0));
    }

    @Test
    public void addSubChapter() {
        target.addSubChapter(new SubChapter("15", "SubChapTitle15", "SubChapDesc15"));
        assertThat(target.getSubChapters().size(), is(2));

        target.addSubChapter(null);
        assertThat(target.getSubChapters().size(), is (2));
    }
}
