package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RangeTest {

    private Range target;

    @Before
    public void setup() {
        target = new Range("1", "Title", "Desc");
    }

    @Test
    public void testHasSubChapters() {
        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testHasItems() {
        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());

        target.addItem(new Item("1", "Title", "Desc"));

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testHasSections() {
        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());

        target.addSection(new Section("1", "Title", "Desc"));

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
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

    @Test
    public void testEquals_WithKeyTitleDesc() {
        final Range range = new Range("1", "Title", "Desc");

        assertTrue(range.equals(target));

        range.setKey("2");

        assertFalse(range.equals(target));

        range.setKey("1");
        range.setTitle("NewTitle");

        assertFalse(range.equals(target));

        range.setTitle("Title");
        range.setDescription("NewDesc");

        assertFalse(range.equals(target));
    }

    @Test
    public void testEquals_WithSubChaptersList() {
        final Range range = new Range("1", "Title", "Desc");

        range.addSubChapters(new ArrayList<>());

        assertFalse(range.equals(target));

        target.addSubChapters(new ArrayList<>());

        assertTrue(range.equals(target));
        range.addSubChapter(new SubChapter("2","Title","Desc"));

        assertFalse(range.equals(target));

        target.addSubChapter(new SubChapter("2","Title","Desc"));

        assertTrue(range.equals(target));

        range.addSubChapter(new SubChapter("3","Title","Desc"));
        target.addSubChapter(new SubChapter("4","Title","Desc"));

        assertFalse(range.equals(target));
    }

    @Test
    public void testEquals_WithItemsList() {
        final Range range = new Range("1", "Title", "Desc");

        range.addItems(new ArrayList<>());

        assertFalse(range.equals(target));

        target.addItems(new ArrayList<>());

        assertTrue(range.equals(target));

        range.addItem(new Item("1", "Title", "Desc"));

        assertFalse(range.equals(target));

        target.addItem(new Item("1", "Title", "Desc"));

        assertTrue(range.equals(target));

        range.addItem(new Item("1", "Title", "Desc"));
        target.addItem(new Item("2", "Title", "Desc"));

        assertFalse(range.equals(target));

    }

    @Test
    public void testEquals_WithSectionsList() {
        final Range range = new Range("1", "Title", "Desc");

        range.addSections(new ArrayList<>());

        assertFalse(range.equals(target));

        target.addSections(new ArrayList<>());

        assertTrue(range.equals(target));
        range.addSection(new Section("1","Title","Desc"));

        assertFalse(range.equals(target));

        target.addSection(new Section("1","Title","Desc"));

        assertTrue(range.equals(target));

        range.addSection(new Section("1","Title","Desc"));
        target.addSection(new Section("2","Title","Desc"));

        assertFalse(range.equals(target));
    }

    @Test
    public void testHashCode(){
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSections())
                .append(target.getItems())
                .append(target.getSubChapters());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }

}