package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    public void testEquals_WithKeyTitleDesc() {
        final Chapter chapter = new Chapter("1", "Title", "Desc");

        assertTrue(chapter.equals(target));

        chapter.setKey("2");

        assertFalse(chapter.equals(target));

        chapter.setKey("1");
        chapter.setTitle("NewTitle");

        assertFalse(chapter.equals(target));

        chapter.setTitle("Title");
        chapter.setDescription("NewDesc");

        assertFalse(chapter.equals(target));
    }

    @Test
    public void testEquals_WithSubChaptersList() {
        final Chapter chapter = new Chapter("1", "Title", "Desc");

        chapter.addSubChapters(new ArrayList<>());

        assertFalse(chapter.equals(target));

        target.addSubChapters(new ArrayList<>());

        assertTrue(chapter.equals(target));
        chapter.addSubChapter(new SubChapter("1","Title","Desc"));

        assertFalse(chapter.equals(target));

        target.addSubChapter(new SubChapter("1","Title","Desc"));

        assertTrue(chapter.equals(target));

        chapter.addSubChapter(new SubChapter("1","Title","Desc"));
        target.addSubChapter(new SubChapter("2","Title","Desc"));

        assertFalse(chapter.equals(target));
    }

    @Test
    public void testHashCode(){
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSubChapters());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }
}