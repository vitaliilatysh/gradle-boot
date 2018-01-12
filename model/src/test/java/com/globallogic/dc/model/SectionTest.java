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
    public void testAddRanges() {
        assertFalse(target.hasRanges());
        target.addRange(new Range("1", "Title", "Desc"));
        assertTrue(target.hasRanges());
        assertEquals(1, target.getRanges().size());
    }

    @Test
    public void testAddRange() {
        assertFalse(target.hasRanges());
        target.addRanges(Arrays.asList(
                new Range("2", "2", "2"),
                new Range("3", "3", "3")));
        assertTrue(target.hasRanges());
        assertEquals(2, target.getRanges().size());
    }

}