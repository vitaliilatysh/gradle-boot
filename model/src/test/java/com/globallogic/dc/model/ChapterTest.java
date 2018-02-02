package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ChapterBuilder;
import com.globallogic.dc.commons.test.SubChapterBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChapterTest {

    private final Chapter target = new ChapterBuilder().defaultInit();
    private final Chapter anotherChapter = new ChapterBuilder().defaultInit();
    private final SubChapter subChapter = new SubChapterBuilder().defaultInit();
    private final SubChapter anotherSubChapter = new SubChapterBuilder().defaultInit();

    @Test
    public void testHasSubChapters_Empty() {
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        target.addSubChapter(subChapter);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSubChapter_IllegalArgumentException() {
        target.addSubChapter(null);
    }

    @Test
    public void testAddSubChapter_NoSubChapterInChapter() {
        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());

        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.getChapter().equals(target));

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_MoveSubChapterToAnotherChapter() {
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
        target.addSubChapters(null);
    }

    @Test
    public void testAddSubChapters() {
        final List<SubChapter> subChapters = Arrays.asList(subChapter, anotherSubChapter);

        target.addSubChapters(subChapters);

        assertTrue(target.hasSubChapters());

        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(target.containsSubChapter(anotherSubChapter));

        assertTrue(subChapter.getChapter().equals(target));
        assertTrue(anotherSubChapter.getChapter().equals(target));
    }
}