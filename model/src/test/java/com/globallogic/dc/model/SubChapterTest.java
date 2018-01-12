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
    public void testHasSubChapter(){
        assertFalse(target.hasChapter());

        target.setChapter(new Chapter("1", "Title", "Desc"));

        assertTrue(target.hasChapter());
    }

    @Test
    public void testHasSections(){
        assertFalse(target.hasSections());

        target.addSection(new Section("2", "Title", "Desc"));

        assertTrue(target.hasSections());

        target.getSections().clear();

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasRanges(){
        assertFalse(target.hasRanges());

        target.addRange(new Range("2", "Title", "Desc"));

        assertTrue(target.hasRanges());

        target.getRanges().clear();

        assertFalse(target.hasRanges());
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
}