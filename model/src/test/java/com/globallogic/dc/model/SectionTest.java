package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SectionTest {

    private Section target;
    private SubChapter subChapter;


    @Before
    public void initParameters() {
        subChapter = new SubChapter("11", "SubChapTitle11", "SubChapDesc11");
    }

    @Before
    public void init() {
        target = new Section("1", "Title", "Desc", subChapter) {
        };
    }

    @Test
    public void hasSubChapter() {
        assertTrue(target.hasSubChapter());

        target = new Section("2", "Title", "Desc");
        assertFalse(target.hasSubChapter());

        target.setSubChapter(null);
        assertFalse(target.hasSubChapter());
    }

}