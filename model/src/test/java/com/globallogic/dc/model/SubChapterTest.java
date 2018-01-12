package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SubChapterTest {

    private SubChapter target;

    @Before
    public void setup() {
        target = new SubChapter("1", "Title", "Desc");
    }

    @Test
    public void addSections() {
        assertFalse(target.hasSections());
        target.addSection(new Section("1", "Title", "Desc"));
        assertTrue(target.hasSections());
        assertEquals(1, target.getSections().size());
    }

    @Test
    public void addSection() {
        assertFalse(target.hasSections());
        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));
        assertTrue(target.hasSections());
        assertEquals(2, target.getSections().size());
    }

    @Test
    public void addRanges() {
        assertFalse(target.hasRanges());
        target.addRange(new Range("1", "Title", "Desc"));
        assertTrue(target.hasRanges());
        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void addRange() {
        assertFalse(target.hasRanges());
        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));
        assertTrue(target.hasRanges());
        assertEquals(2, target.getRanges().size());
    }
}