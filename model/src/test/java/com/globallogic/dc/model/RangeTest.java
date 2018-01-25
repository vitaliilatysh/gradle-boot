package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void testHasSubChapters_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getSubChapters());
        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasSubChapters() {
        final Range target = buildRange(true, false, false);

        assertNotNull(target.getSubChapters());
        assertTrue(target.hasSubChapters());
    }

    @Test
    public void testHasItems_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        final Range target = buildRange(false, true, false);

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testHasSections_Empty() {
        final Range target = buildRange(false, false, false);

        assertNull(target.getSections());
        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
    }

    @Test
    public void testHasSections() {
        final Range target = buildRange(false, false, true);

        assertNotNull(target.getSections());
        assertTrue(target.hasSections());
    }

    @Test
    public void testAddItem() {
        final Range target = buildRange(false, false, false);

        target.addItem(new Item("1", "Title", "Desc"));

        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItems() {
        final Range target = buildRange(false, false, false);

        target.addItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertEquals(2, target.getItems().size());
    }

    @Test
    public void testAddSubChapter() {
        final Range target = buildRange(false, false, false);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertEquals(1, target.getSubChapters().size());
    }

    @Test
    public void testAddSubChapters() {
        final Range target = buildRange(false, false, false);

        target.addSubChapters(Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3")));

        assertEquals(2, target.getSubChapters().size());
    }

    @Test
    public void testAddSection() {
        final Range target = buildRange(false, false, false);

        target.addSection(new Section("1", "Title", "Desc"));

        assertEquals(1, target.getSections().size());
    }

    @Test
    public void testAddSections() {
        final Range target = buildRange(false, false, false);

        target.addSections(Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3")));

        assertEquals(2, target.getSections().size());
    }

    private Range buildRange(final boolean fillSubChapters, final boolean fillItems, final boolean fillSections) {
        return this.buildRange("1", "Title", "Desc", fillSubChapters, fillItems, fillSections);
    }

    private Range buildRange(
            final String key,
            final String title,
            final String description,
            final boolean fillSubChapters,
            final boolean fillItems,
            final boolean fillSections) {
        final Range result = new Range(key, title, description);

        if (fillSubChapters) {
            result.addSubChapters(Arrays.asList(
                    new SubChapter("1", "Title", "Desc"),
                    new SubChapter("2", "Title", "Desc")));
        }

        if (fillItems) {
            result.addItems(Arrays.asList(
                    new Item("1", "Title", "Desc"),
                    new Item("2", "Title", "Desc")));
        }

        if (fillSections) {
            result.addSections(Arrays.asList(
                    new Section("1", "Title", "Desc"),
                    new Section("2", "Title", "Desc")));
        }
        return result;
    }
}