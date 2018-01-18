package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ChapterTest {

    private Chapter target, chapter;
    private SubChapter subChapter1, subChapter2;

    @Before
    public void setup() {
        target = new Chapter("1", "Title", "Desc");

        chapter = new Chapter("1", "Title", "Desc");
        subChapter1 = new SubChapter("1", "Title", "Desc");
        subChapter2 = new SubChapter("2", "Title", "Desc");

        chapter.addSubChapters(Arrays.asList(subChapter1, subChapter2));
    }

    @Test
    public void testHasSubChapters() {
        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());
        assertFalse(target.hasSubChapters());

        target.addSubChapter(subChapter1);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());

    }

    @Test
    public void testAddSubChapter() {
        target.addSubChapter(subChapter1);

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        target.addSubChapters(Arrays.asList(subChapter1, subChapter2));

        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testEquals_NotEqualKey() {
        chapter.setKey("2");

        assertFalse(chapter.getKey().equals(target.getKey()));
    }

    @Test
    public void testEquals_NotEqualTitle() {
        chapter.setTitle("NewTitle");

        assertFalse(chapter.getTitle().equals(target.getTitle()));
    }

    @Test
    public void testEquals_NotEqualDesc() {
        chapter.setDescription("NewDesc");

        assertFalse(chapter.getDescription().equals(target.getDescription()));
    }

    @Test
    public void testEquals_NotEqualSubChapterListEmpty() {
        target.addSubChapters(new ArrayList<>());

        assertFalse(chapter.getSubChapters().equals(target.getSubChapters()));
    }

    @Test
    public void testEquals_NotEqualSubChaptersListContains1SubChapter() {
        target.addSubChapter(subChapter1);

        assertFalse(chapter.getSubChapters().equals(target.getSubChapters()));
    }

    @Test
    public void testEquals_NotEqualSubChaptersListContainsTheSameNumberOfSubChapters() {
        target.addSubChapters(Arrays.asList(subChapter1, subChapter1));

        assertFalse(chapter.getSubChapters().equals(target.getSubChapters()));
    }

    @Test
    public void testEquals_EqualAllFields() {
        target.addSubChapters(Arrays.asList(subChapter1, subChapter2));

        assertTrue(chapter.equals(target));
    }

    @Test
    public void testHashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSubChapters());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }
}