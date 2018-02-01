package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.globallogic.dc.commons.test.ChapterBuilder.buildChapter;
import static org.junit.Assert.*;

public class ChapterTest {

    @Test
    public void testHasSubChapters_Empty() {
        final Chapter target = buildChapter(false);

        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        final Chapter target = buildChapter(true);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSubChapter_IllegalArgumentException() {
        final Chapter target = buildChapter(false);

        target.addSubChapter(null);
    }

    @Test
    public void testAddSubChapter_NoSubChapterInChapter() {
        final Chapter target = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.getChapter().equals(target));
        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_MoveSubChapterToAnotherChapter() {
        final Chapter target = buildChapter(false);
        final Chapter anotherChapter = buildChapter(false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);
        anotherChapter.addSubChapter(subChapter);

        assertFalse(target.hasSubChapters());
        assertTrue(anotherChapter.hasSubChapters());
        assertTrue(anotherChapter.containsSubChapter(subChapter));
        assertTrue(subChapter.getChapter().equals(anotherChapter));
        assertEquals(1, anotherChapter.getSubChapters().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSubChapters_IllegalArgumentException() {
        final Chapter target = buildChapter(false);

        target.addSubChapters(null);
    }

    @Test
    public void testAddSubChapters() {
        final Chapter target = buildChapter(false);
        final SubChapter subChapter1 = new SubChapter("1", "Title", "Desc");
        final SubChapter subChapter2 = new SubChapter("1", "Title", "Desc");
        final List<SubChapter> subChapters = Arrays.asList(subChapter1, subChapter2);

        target.addSubChapters(subChapters);

        assertTrue(target.hasSubChapters());

        assertTrue(target.containsSubChapter(subChapter1));
        assertTrue(target.containsSubChapter(subChapter2));

        assertTrue(subChapter1.getChapter().equals(target));
        assertTrue(subChapter2.getChapter().equals(target));
    }
}