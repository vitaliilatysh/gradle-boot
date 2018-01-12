package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ChapterTest {

    private Chapter target;

    @Before
    public void setup() {
        target = new Chapter("1", "Title", "Desc");
    }

    @Test
    public void testHasSubChapters() {
        assertFalse(target.hasSubChapters());

        target.addSubChapter(new SubChapter("2", "2", "2"));

        assertTrue(target.hasSubChapters());

        target.getSubChapters().clear();

        assertFalse(target.hasSubChapters());

    }

    @Test
    public void testAddSubChapter() {
        target.addSubChapter(new SubChapter("2", "2", "2"));

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        target.addSubChapters(Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3")));

        assertEquals(2, target.getSubChapters().size());
    }
}
