package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SectionTest {

    private Section target, section;

    @Before
    public void setup() {
        target = new Section("1", "Title", "Desc");
        section = new Section("1", "Title", "Desc");
    }

    @Test
    public void testHasRanges() {
        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());

        target.addRange(new Range("1", "Title", "Desc"));

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test
    public void testHasSubChapter() {
        assertNull(target.getSubChapter());
        assertFalse(target.hasSubChapter());

        target.setSubChapter(new SubChapter("1", "Title", "Desc"));

        assertNotNull(target.getSubChapter());
        assertTrue(target.hasSubChapter());
    }

    @Test
    public void testAddRanges() {
        target.addRange(new Range("1", "Title", "Desc"));

        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void testAddRange() {
        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));

        assertEquals(2, target.getRanges().size());
    }

    @Test
    public void testEqualsKey() {
        section.setKey("2");

        assertFalse(section.equals(target));

        section.setKey("1");

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsTitle() {
        section.setTitle("NewTitle");

        assertFalse(section.equals(target));

        section.setTitle("Title");

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsDesc() {
        section.setDescription("NewDesc");

        assertFalse(section.equals(target));

        section.setDescription("Desc");

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsSameSubChapterInside() {
        section.setSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(section.equals(target));

        target.setSubChapter(new SubChapter("1", "Title", "Desc"));

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsDiffSubChapterInside() {
        section.setSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(section.equals(target));

        target.setSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(section.equals(target));
    }

    @Test
    public void testEqualsEmptyRangesList() {
        section.addRanges(new ArrayList<>());

        assertFalse(section.equals(target));

        target.addRanges(new ArrayList<>());

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsSameRangeInsideList() {
        section.addRange(new Range("1", "Title", "Desc"));

        assertFalse(section.equals(target));

        target.addRange(new Range("1", "Title", "Desc"));

        assertTrue(section.equals(target));
    }

    @Test
    public void testEqualsDiffRangeInsideList() {
        section.addRange(new Range("1", "Title", "Desc"));

        assertFalse(section.equals(target));

        target.addRange(new Range("2", "Title", "Desc"));

        assertFalse(section.equals(target));
    }

    @Test
    public void testHashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getRanges())
                .append(target.getSubChapter());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }

}