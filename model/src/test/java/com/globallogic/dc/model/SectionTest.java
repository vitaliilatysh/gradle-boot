package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

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
        assertFalse(target.hasRanges());

        target.addRange(new Range("1", "Title", "Desc"));

        assertTrue(target.hasRanges());

        target.getRanges().clear();

        assertFalse(target.hasRanges());
    }

    @Test
    public void testHasSubChapter(){
        assertFalse(target.hasSubChapter());

        target.setSubChapter(new SubChapter("1", "Title", "Desc"));

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