package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

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

    @Test
    public void testEquals() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        assertTrue(target.equals(anotherItem));
    }

    @Test
    public void testEquals_DifferentKeys() {
        final Item target = buildItem("2", "Title", "Desc", true, true, true);
        final Item anotherItem = buildItem("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_DifferentTitles() {
        final Item target = buildItem("1", "NewTitle", "Desc", true, true, true);
        final Item anotherItem = buildItem("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_DifferentDesc() {
        final Item target = buildItem("1", "Title", "NewDesc", true, true, true);
        final Item anotherItem = buildItem("1", "Title", "Desc", true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetRangeNotSet() {
        final Item target = buildItem(true, true, false);
        final Item anotherItem = buildItem(true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetDiffRange() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.setRange(new Range("2", "Title", "Desc"));

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetItemsListNotSet() {
        final Item target = buildItem(false, true, true);
        final Item anotherItem = buildItem(true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetItemsListEmpty() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.setItems(new ArrayList<>());

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetItemsListContainsDiffNumberOfItems() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.addItem(new Item("1", "Title", "Desc"));

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetItemsListContainsTheSameNumberOfItemsButDiff() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.addItem(new Item("1", "Title", "Desc"));
        anotherItem.addItem(new Item("2", "Title", "Desc"));

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetRelatedItemsListNotSet() {
        final Item target = buildItem(true, false, true);
        final Item anotherItem = buildItem(true, true, true);

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetRelatedItemsListEmpty() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.setRelatedItems(new ArrayList<>());

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetRelatedItemsListContainsDiffNumberOfRelatedItems() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.addRelatedItem(new Item("1", "Title", "Desc"));

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testEquals_TargetRelatedItemsListContainsTheSameNumberOfItemsButDiff() {
        final Item target = buildItem(true, true, true);
        final Item anotherItem = buildItem(true, true, true);

        target.addRelatedItem(new Item("1", "Title", "Desc"));
        anotherItem.addRelatedItem(new Item("2", "Title", "Desc"));

        assertFalse(target.equals(anotherItem));
    }

    @Test
    public void testHashCode() {
        final Item target = buildItem(true, true, true);
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getRange())
                .append(target.getItems())
                .append(target.getRelatedItems());


        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
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