package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RangeTest {

    private Range target;

    @Before
    public void setup() {
        target = new Range("1", "Title", "Desc");
    }

    @Test
    public void testAddItems() {
        assertFalse(target.hasItems());

        target.addItem(new Item("1", "Title", "Desc"));

        assertTrue(target.hasItems());
        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem() {
        assertFalse(target.hasItems());

        target.addItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertTrue(target.hasItems());
        assertEquals(2, target.getItems().size());
    }

    @Test
    public void testAddSubChapters() {
        assertFalse(target.hasSubChapters());

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertTrue(target.hasSubChapters());
        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter() {
        assertFalse(target.hasSubChapters());

        target.addSubChapters(Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3")));

        assertTrue(target.hasSubChapters());
        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testAddSections() {
        assertFalse(target.hasSections());

        target.addSection(new Section("1", "Title", "Desc"));

        assertTrue(target.hasSections());
        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSection() {
        assertFalse(target.hasSections());

        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));

        assertTrue(target.hasSections());
        assertEquals(2, target.getSections().size());
    }

}