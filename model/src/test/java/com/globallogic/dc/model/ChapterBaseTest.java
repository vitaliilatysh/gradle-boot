package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class ChapterBaseTest {

    private ChapterBase target;
    private SubChapter subChapter;
    private List<SubChapter> subChapters;

    @Before
    public void init() {
        subChapters = new ArrayList<>();
        subChapter = new SubChapter("11", "SubChapTitle11", "SubChapDesc11");
        subChapters.add(subChapter);
        target = new ChapterBase("1", "Title", "Desc", subChapters) {
        };
    }

    @Test
    public void getSubChapters() {
        assertThat(target.getSubChapters(), hasItems(subChapter));
    }

    @Test
    public void setSubChapters() {
        List<SubChapter> newSubChapterList = new ArrayList<>();
        newSubChapterList.add(new SubChapter("12", "SubChapTitle12", "NewSubChapDesc12"));
        target.setSubChapters(newSubChapterList);

        assertThat(target.getSubChapters().size(), is(1));
        assertEquals("12", target.getSubChapters().get(0).getKey());
    }

    @Test
    public void hasSubChapters() {
        assertTrue(target.hasSubChapters());
        subChapters.remove(subChapter);
        assertFalse(target.hasSubChapters());
    }

    @Test
    public void addSubChapters() {
        target.addSubChapters(subChapters);
        assertThat(target.getSubChapters().size(), is(2));
    }

    @Test
    public void addSubChapter() {
        target.addSubChapter(new SubChapter("15", "SubChapTitle15", "SubChapDesc15"));
        assertThat(target.getSubChapters().size(), is(2));
    }
}
