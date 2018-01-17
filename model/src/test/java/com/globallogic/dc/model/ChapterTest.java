package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());
        assertFalse(target.hasSubChapters());

        target.addSubChapter(new SubChapter("2", "2", "2"));

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());

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

    @Test
    public void testEqualsAndHashCode(){
        final Chapter chapter1 = new Chapter("1", "Title", "Desc");
        final Chapter chapter2 = new Chapter("1", "Title1", "Desc");
        final Chapter chapter3 = new Chapter("1", "Title", "Desc1");

        assertTrue(chapter1.equals(target));
        assertEquals(chapter1.hashCode(), target.hashCode());
        assertFalse(chapter2.equals(target));
        assertNotEquals(chapter2.hashCode(), target.hashCode());
        assertFalse(chapter3.equals(target));
        assertNotEquals(chapter3.hashCode(), target.hashCode());

        chapter1.addSubChapters(new ArrayList<>());

        assertFalse(chapter1.equals(target));
        assertNotEquals(chapter1.hashCode(), target.hashCode());

        target.addSubChapters(new ArrayList<>());

        assertTrue(chapter1.equals(target));
        assertEquals(chapter1.hashCode(), target.hashCode());

        chapter1.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(chapter1.equals(target));
        assertNotEquals(chapter1.hashCode(), target.hashCode());

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertTrue(chapter1.equals(target));
        assertEquals(chapter1.hashCode(), target.hashCode());

        chapter1.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(chapter1.equals(target));
        assertNotEquals(chapter1.hashCode(), target.hashCode());

        target.addSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(chapter1.equals(target));
        assertNotEquals(chapter1.hashCode(), target.hashCode());
    }
}
