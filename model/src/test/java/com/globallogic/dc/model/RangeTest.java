package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RangeTest {

    private Range target;

    @Before
    public void setup() {
        target = new Range("1", "Title", "Desc");
    }

    @Test
    public void testHasSubChapters(){
        assertFalse(target.hasSubChapters());

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertTrue(target.hasSubChapters());

        target.getSubChapters().clear();

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasItems(){
        assertFalse(target.hasItems());

        target.addItem(new Item("1", "Title", "Desc"));

        assertTrue(target.hasItems());

        target.getItems().clear();

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasSections(){
        assertFalse(target.hasSections());

        target.addSection(new Section("1", "Title", "Desc"));

        assertTrue(target.hasSections());

        target.getSections().clear();

        assertFalse(target.hasSections());
    }

    @Test
    public void testAddItems() {
        target.addItem(new Item("1", "Title", "Desc"));

        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem() {
        target.addItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertEquals(2, target.getItems().size());
    }

    @Test
    public void testAddSubChapters() {
        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapter() {
        target.addSubChapters(Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3")));

        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testAddSections() {
        target.addSection(new Section("1", "Title", "Desc"));

        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSection() {
        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));

        assertEquals(2, target.getSections().size());
    }

}