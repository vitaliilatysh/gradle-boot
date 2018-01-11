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
    public void testAddSubChapter() {
        final Chapter c = new Chapter("1", "2", "3");

        assertFalse(c.hasSubChapters());

        c.addSubChapter(new SubChapter("2", "2", "2"));

        assertTrue(c.hasSubChapters());
        assertNotNull(c.getSubChapters());
        assertEquals(1, c.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        final Chapter c = new Chapter("1", "2", "3");

        assertFalse(c.hasSubChapters());

        c.addSubChapters(Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3")));

        assertTrue(c.hasSubChapters());
        assertNotNull(c.getSubChapters());
        assertEquals(2, c.getSubChapters().size());
    }
}
