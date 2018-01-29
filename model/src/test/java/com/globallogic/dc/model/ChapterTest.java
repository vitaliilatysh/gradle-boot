package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testAddSubChapters() {
        final Chapter target = buildChapter(false);
        final List<SubChapter> subChapters = Arrays.asList(
                new SubChapter("1", "Title", "Desc"),
                new SubChapter("1", "Title", "Desc"));

        target.addSubChapters(subChapters);

        for (SubChapter subChapter : subChapters) {
            assertTrue(target.hasSubChapters());
            assertTrue(target.containsSubChapter(subChapter));
            assertTrue(subChapter.hasChapter());
            assertTrue(subChapter.getChapter().equals(target));
        }
        assertEquals(2, target.getSubChapters().size());
    }

    private Chapter buildChapter(final boolean fillSubChapters) {
        return this.buildChapter("1", "Title", "Desc", fillSubChapters);
    }

    private Chapter buildChapter(
            final String key,
            final String title,
            final String description,
            final boolean fillSubChapters) {
        final Chapter result = new Chapter(key, title, description);

        if (fillSubChapters) {
            result.addSubChapters(Arrays.asList(
                    new SubChapter("1", "Title", "Desc"),
                    new SubChapter("2", "Title", "Desc")));
        }

        return result;
    }


}