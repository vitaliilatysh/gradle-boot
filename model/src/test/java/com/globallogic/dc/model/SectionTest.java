package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SectionTest {

    private Section target;

    @Before
    public void setup() {
        target = new Section("1", "Title", "Desc");
    }

    @Test
    public void testHasRanges(){
        assertNull(target.getRanges());
        assertFalse(target.hasRanges());

        target.addRanges(new ArrayList<>());

        assertFalse(target.hasRanges());

        target.addRange(new Range("1", "Title", "Desc"));

        assertNotNull(target.getRanges());
        assertTrue(target.hasRanges());
    }

    @Test
    public void testHasSubChapter(){
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

}