package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testSetRange_IfItemNotAssignedToRangeBefore() {
        final Item target = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");

        target.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.getItems().contains(target));
        assertEquals(1, range.getItems().size());
    }

    @Test
    public void testSetRange_IfAnotherItemAlreadyAssignedToRange() {
        final Item target = buildItem(false, false, true);
        final Item anotherItem = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");

        target.setRange(range);
        anotherItem.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.getItems().contains(target));
        assertTrue(anotherItem.hasRange());
        assertTrue(anotherItem.getRange().equals(range));
        assertTrue(range.getItems().contains(anotherItem));
        assertEquals(2, range.getItems().size());
    }

    @Test
    public void testSetRange_IfItemWasAssignedAndThenReassignedToAnotherRange() {
        final Item target = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");
        final Range anotherRange = new Range("1", "Title", "Desc");

        target.setRange(range);
        target.setRange(anotherRange);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(anotherRange));
        assertTrue(anotherRange.getItems().contains(target));
        assertEquals(1, anotherRange.getItems().size());
    }

    @Test
    public void testSetRange_IfRangeContains2ItemsAndThen1ItemReassignedToAnotherRange() {
        final Item target = buildItem(false, false, true);
        final Item anotherItem = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");
        final Range anotherRange = new Range("1", "Title", "Desc");

        target.setRange(range);
        anotherItem.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.getItems().contains(target));
        assertTrue(anotherItem.hasRange());
        assertEquals(2, range.getItems().size());

        target.setRange(anotherRange);

        assertTrue(range.getItems().contains(anotherItem));
        assertTrue(anotherItem.getRange().equals(range));
        assertTrue(anotherRange.getItems().contains(target));
        assertTrue(target.getRange().equals(anotherRange));
        assertEquals(1, range.getItems().size());
        assertEquals(1, anotherRange.getItems().size());
    }

    @Test
    public void testHasRelatedItems_Empty() {
        final Item target = buildItem(false, false, false);

        assertNull(target.getRelatedItems());
        assertFalse(target.hasRelatedItems());

        target.addRelatedItems(new ArrayList<>());

        assertFalse(target.hasRelatedItems());
    }

    @Test
    public void testHasRelatedItems() {
        final Item target = buildItem(false, true, false);

        assertNotNull(target.getRelatedItems());
        assertTrue(target.hasRelatedItems());
    }

    @Test
    public void testHasRange_NotSet() {
        final Item target = buildItem(false, false, false);

        assertNull(target.getRange());
        assertFalse(target.hasRange());
    }

    @Test
    public void testHasRange() {
        final Item target = buildItem(false, false, true);

        assertNotNull(target.getRange());
        assertTrue(target.hasRange());
    }

    @Test
    public void testHasItems_Empty() {
        final Item target = buildItem(false, false, false);

        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        final Item target = buildItem(true, false, false);

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test
    public void testAddRelatedItem() {
        final Item target = buildItem(false, false, false);

        target.addRelatedItem(new Item("2", "2", "2"));

        assertEquals(1, target.getRelatedItems().size());
    }

    @Test
    public void testAddRelatedItems() {
        final Item target = buildItem(false, false, false);

        target.addRelatedItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertEquals(2, target.getRelatedItems().size());
    }

    @Test
    public void testAddItem() {
        final Item target = buildItem(false, false, false);

        target.addItem(new Item("2", "2", "2"));

        assertEquals(1, target.getItems().size());
    }

    @Test
    public void testAddItems() {
        final Item target = buildItem(false, false, false);

        target.addItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertEquals(2, target.getItems().size());
    }

    private Item buildItem(final boolean fillItems, final boolean fillRelatedItems, final boolean fillRange) {
        return this.buildItem("1", "Title", "Desc", fillItems, fillRelatedItems, fillRange);
    }

    private Item buildItem(
            final String key,
            final String title,
            final String description,
            final boolean fillItems,
            final boolean fillRelatedItems,
            final boolean fillRange) {
        final Item result = new Item(key, title, description);

        if (fillItems) {
            result.addItems(Arrays.asList(
                    new Item("1", "Title", "Desc"),
                    new Item("2", "Title", "Desc")));
        }

        if (fillRelatedItems)
            result.addRelatedItems(Arrays.asList(
                    new Item("1", "Title", "Desc"),
                    new Item("2", "Title", "Desc")));

        if (fillRange)
            result.setRange(new Range("1", "Title", "Desc"));

        return result;
    }
}