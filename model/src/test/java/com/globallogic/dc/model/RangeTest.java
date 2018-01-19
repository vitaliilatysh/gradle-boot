package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void testHasSubChapters() {
        assertTrue(buildRange(true, false, false).hasSubChapters());
    }

    @Test
    public void testHasSubChapters_Empty() {
        final Range target = buildRange(false, false, false);

        assertFalse(target.hasSubChapters());

        target.addSubChapters(new ArrayList<>());

        assertFalse(target.hasSubChapters());
    }

    @Test
    public void testHasItems() {
        assertTrue(buildRange(false, true, false).hasItems());
    }

    @Test
    public void testHasItems_Empty() {
        final Range target = buildRange(false, false, false);

        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasSections() {
        assertTrue(buildRange(false, false, true).hasSections());
    }

    @Test
    public void testHasSections_Empty() {
        final Range target = buildRange(false, false, false);

        assertFalse(target.hasSections());

        target.addSections(new ArrayList<>());

        assertFalse(target.hasSections());
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

    @Test
    public void testEquals() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        assertTrue(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_Key() {
        final Range target = buildRange("2", "Title", "Desc", true, true, true);
        final Range anotherRange = buildRange("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_Title() {
        final Range target = buildRange("1", "NewTitle", "Desc", true, true, true);
        final Range anotherRange = buildRange("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_Desc() {
        final Range target = buildRange("1", "Title", "NewDesc", true, true, true);
        final Range anotherRange = buildRange("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListNotSet() {
        final Range target = buildRange(false, true, true);
        final Range anotherRange = buildRange(true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListEmpty() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.setSubChapters(new ArrayList<>());

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListContainsDiffNumberOfSubChapters() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SubChaptersListContainsTheSameNumberOfSubChaptersButDiff() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addSubChapter(new SubChapter("1", "Title", "Desc"));
        anotherRange.addSubChapter(new SubChapter("2", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_ItemsListNotSet() {
        final Range target = buildRange(true, false, true);
        final Range anotherRange = buildRange(true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_ItemsListEmpty() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.setItems(new ArrayList<>());

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_ItemsListContainsDiffNumberOfItems() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addItem(new Item("1", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_ItemsListContainsTheSameNumberOfItemsButDiff() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addItem(new Item("1", "Title", "Desc"));
        anotherRange.addItem(new Item("2", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SectionsListNotSet() {
        final Range target = buildRange(true, true, false);
        final Range anotherRange = buildRange(true, true, true);

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SectionsListEmpty() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.setSections(new ArrayList<>());

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SectionsListContainsDiffNumberOfSections() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addSection(new Section("1", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testEquals_NotEqual_SectionsListContainsSameNumberOfSectionsButDiff() {
        final Range target = buildRange(true, true, true);
        final Range anotherRange = buildRange(true, true, true);

        target.addSection(new Section("1", "Title", "Desc"));
        anotherRange.addSection(new Section("2", "Title", "Desc"));

        assertFalse(target.equals(anotherRange));
    }

    @Test
    public void testHashCode() {
        final Range target = buildRange(true, true, true);
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getSubChapters())
                .append(target.getItems())
                .append(target.getSections());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
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