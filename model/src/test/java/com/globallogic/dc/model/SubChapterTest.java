package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SubChapterTest {

    private SubChapter target;

    @Before
    public void setup() {
        target = new SubChapter("1", "Title", "Desc");
    }

    @Test
    public void testHasSubChapter(){
        assertNull(target.getChapter());
        assertFalse(target.hasChapter());

        target.setChapter(new Chapter("1", "Title", "Desc"));

        assertNotNull(target.getChapter());
        assertTrue(target.hasChapter());
    }

    @Test
    public void testHasSections(){
        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());

        target.addSection(new Section("2", "Title", "Desc"));

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test
    public void testHasRanges(){
        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());

        target.addRange(new Range("2", "Title", "Desc"));

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test
    public void addSections() {
        target.addSection(new Section("1", "Title", "Desc"));

        assertEquals(1, target.getSections().size());
    }

    @Test
    public void addSection() {
        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));

        assertEquals(2, target.getSections().size());
    }

    @Test
    public void addRanges() {
        target.addRange(new Range("1", "Title", "Desc"));

        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void addRange() {
        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));

        assertEquals(2, target.getRanges().size());
    }

    @Test
    public void testEquals_WithKeyTitleDesc() {
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        assertTrue(subChapter.equals(target));

        subChapter.setKey("2");

        assertFalse(subChapter.equals(target));

        subChapter.setKey("1");
        subChapter.setTitle("NewTitle");

        assertFalse(subChapter.equals(target));

        subChapter.setTitle("Title");
        subChapter.setDescription("NewDesc");

        assertFalse(subChapter.equals(target));
    }

    @Test
    public void testEquals_WithChapter() {
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        subChapter.setChapter(new Chapter("1", "Title", "Desc"));

        assertFalse(subChapter.equals(target));

        target.setChapter(new Chapter("1", "Title", "Desc"));

        assertTrue(subChapter.equals(target));

        subChapter.setChapter(new Chapter("1", "Title", "Desc"));
        target.setChapter(new Chapter("2", "Title", "Desc"));

        assertFalse(subChapter.equals(target));
    }

    @Test
    public void testEquals_WithSectionsList() {
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        subChapter.addSections(new ArrayList<>());

        assertFalse(subChapter.equals(target));

        target.addSections(new ArrayList<>());

        assertTrue(subChapter.equals(target));
        subChapter.addSection(new Section("1","Title","Desc"));

        assertFalse(subChapter.equals(target));

        target.addSection(new Section("1","Title","Desc"));

        assertTrue(subChapter.equals(target));

        subChapter.addSection(new Section("1","Title","Desc"));
        target.addSection(new Section("2","Title","Desc"));

        assertFalse(subChapter.equals(target));
    }

    @Test
    public void testEquals_WithRangesList() {
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        subChapter.addRanges(new ArrayList<>());

        assertFalse(subChapter.equals(target));

        target.addRanges(new ArrayList<>());

        assertTrue(subChapter.equals(target));
        subChapter.addRange(new Range("1","Title","Desc"));

        assertFalse(subChapter.equals(target));

        target.addRange(new Range("1","Title","Desc"));

        assertTrue(subChapter.equals(target));

        subChapter.addRange(new Range("1","Title","Desc"));
        target.addRange(new Range("2","Title","Desc"));

        assertFalse(subChapter.equals(target));
    }

    @Test
    public void testHashCode(){
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSections())
                .append(target.getRanges())
                .append(target.getChapter());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }
}