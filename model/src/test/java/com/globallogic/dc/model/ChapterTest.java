package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ChapterBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ChapterTest {

    private Chapter target;

    @Before
    public void setUp() {
        target = new ChapterBuilder.Builder()
                .key("1")
                .title("Title")
                .description("Desc")
                .build();
    }

    @Test
    public void testHasSubChapters_Empty() {
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        SubChapter subChapter = new SubChapter("1", "Title", "Desc");

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
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.getChapter().equals(target));
        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter_MoveSubChapterToAnotherChapter() {
        final Chapter anotherChapter = new ChapterBuilder.Builder()
                .key("1")
                .title("Title")
                .description("Desc")
                .build();
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
        target.addSubChapters(null);
    }

    @Test
    public void testAddSubChapters() {
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