package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void testAddSubChapter_NoSubChapterInRange() {
        final Range target = buildRange(false, false, false);
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.hasRanges());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.containsRange(target));
        assertEquals(1, target.getSubChapters().size());
        assertEquals(1, subChapter.getRanges().size());
    }

    @Test
    public void testAddSubChapter_MoveSubChapterToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = new Range("3", "Title", "Desc");
        final SubChapter subChapter = new SubChapter("1", "Title", "Desc");

        target.addSubChapter(subChapter);
        anotherRange.addSubChapter(subChapter);

        assertTrue(target.hasSubChapters());
        assertTrue(subChapter.hasRanges());
        assertTrue(target.containsSubChapter(subChapter));
        assertTrue(subChapter.containsRange(target));
        assertTrue(subChapter.containsRange(anotherRange));
        assertEquals(1, target.getSubChapters().size());
        assertEquals(1, anotherRange.getSubChapters().size());
        assertEquals(2, subChapter.getRanges().size());
    }

    @Test
    public void testAddSubChapters() {
        final Range target = buildRange(false, false, false);
        final List<SubChapter> subChapters = Arrays.asList(
                new SubChapter("2", "2", "2"),
                new SubChapter("3", "3", "3"));

        target.addSubChapters(subChapters);

        for (SubChapter subChapter : subChapters) {
            assertTrue(target.hasSubChapters());
            assertTrue(target.containsSubChapter(subChapter));
            assertTrue(subChapter.hasRanges());
            assertTrue(subChapter.containsRange(target));
        }

        assertEquals(2, target.getSubChapters().size());
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
    public void testAddItem_NoItemInRange() {
        final Range target = buildRange(false, false, false);
        final Item item = new Item("1", "Title", "Desc");

        target.addItem(item);

        assertTrue(target.hasItems());
        assertTrue(item.getRange().equals(target));
        assertTrue(target.containsItem(item));
        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItem_MoveItemToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = buildRange(false, false, false);
        final Item item = new Item("1", "Title", "Desc");

        target.addItem(item);
        anotherRange.addItem(item);

        assertFalse(target.hasItems());
        assertTrue(anotherRange.hasItems());
        assertTrue(anotherRange.containsItem(item));
        assertTrue(item.getRange().equals(anotherRange));
        assertEquals(1, anotherRange.getItems().size());
    }

    @Test
    public void testAddItems() {
        final Range target = buildRange(false, false, false);
        final List<Item> items = Arrays.asList(
                new Item("1", "Title", "Desc"),
                new Item("1", "Title", "Desc"));

        target.addItems(items);

        for (Item item : items) {
            assertTrue(target.hasItems());
            assertTrue(target.containsItem(item));
            assertTrue(item.hasRange());
            assertTrue(item.getRange().equals(target));
        }
        assertEquals(2, target.getItems().size());
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

    @Test(expected = IllegalArgumentException.class)
    public void testAddSection_Null(){
        final Range target = buildRange(false, false, false);

        target.addSection(null);
    }

    @Test
    public void testAddSection_NoSectionInRange() {
        final Range target = buildRange(false, false, false);
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.hasRanges());
        assertTrue(target.containsSection(section));
        assertTrue(section.containsRange(target));
        assertEquals(1, target.getSections().size());
        assertEquals(1, section.getRanges().size());
    }

    @Test
    public void testAddSection_MoveSectionToAnotherRange() {
        final Range target = buildRange(false, false, false);
        final Range anotherRange = new Range("3", "Title", "Desc");
        final Section section = new Section("1", "Title", "Desc");

        target.addSection(section);
        anotherRange.addSection(section);

        assertTrue(target.hasSections());
        assertTrue(section.hasRanges());
        assertTrue(anotherRange.hasSections());
        assertTrue(target.containsSection(section));
        assertTrue(section.containsRange(target));
        assertTrue(section.containsRange(anotherRange));
        assertTrue(anotherRange.containsSection(section));
        assertEquals(1, target.getSections().size());
        assertEquals(1, anotherRange.getSections().size());
        assertEquals(2, section.getRanges().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSections_Null(){
        final Range target = buildRange(false, false, false);

        target.addSections(null);
    }

    @Test
    public void testAddSections() {
        final Range target = buildRange(false, false, false);
        final List<Section> sections = Arrays.asList(
                new Section("2", "2", "2"),
                new Section("3", "3", "3"));

        target.addSections(sections);

        for (Section section : sections) {
            assertTrue(target.hasSections());
            assertTrue(target.containsSection(section));
            assertTrue(section.hasRanges());
            assertTrue(section.containsRange(target));
        }
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