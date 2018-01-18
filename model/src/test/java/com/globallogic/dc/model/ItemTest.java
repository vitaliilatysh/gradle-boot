package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

    private Item target, item;

    @Before
    public void setup() {
        target = new Item("1", "Title", "Desc");
        item = new Item("1", "Title", "Desc");

    }

    @Test
    public void testHasRelatedItems() {
        assertNull(target.getRelatedItems());
        assertFalse(target.hasRelatedItems());

        target.addRelatedItems(new ArrayList<>());

        assertFalse(target.hasRelatedItems());

        target.addRelatedItem(new Item("2", "2", "2"));

        assertNotNull(target.getRelatedItems());
        assertTrue(target.hasRelatedItems());

    }

    @Test
    public void testHasRange() {
        assertNull(target.getRange());
        assertFalse(target.hasRange());

        target.setRange(new Range("1", "Title", "Desc"));

        assertNotNull(target.getRange());
        assertTrue(target.hasRange());
    }

    @Test
    public void testHasItems() {
        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());

        target.addItem(new Item("2", "Title", "Desc"));

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }


    @Test
    public void testAddRelatedItems() {
        target.addRelatedItem(new Item("2", "2", "2"));

        assertEquals(1, target.getRelatedItems().size());
    }

    @Test
    public void testAddRelatedItem() {
        target.addRelatedItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));

        assertEquals(2, target.getRelatedItems().size());
    }

    @Test
    public void testAddItems() {
        target.addItem(new Item("2", "2", "2"));

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
    public void testEqualsKey() {
        item.setKey("2");

        assertFalse(item.equals(target));

        item.setKey("1");

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsTitle() {
        item.setTitle("NewTitle");

        assertFalse(item.equals(target));

        item.setTitle("Title");

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsDesc() {
        item.setDescription("NewDesc");

        assertFalse(item.equals(target));

        item.setDescription("Desc");

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsSameRangeInside() {
        item.setRange(new Range("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.setRange(new Range("1", "Title", "Desc"));

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsDiffRangeInside() {
        item.setRange(new Range("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.setRange(new Range("2", "Title", "Desc"));

        assertFalse(item.equals(target));
    }

    @Test
    public void testEqualsEmptyItemsList() {
        item.addItems(new ArrayList<>());

        assertFalse(item.equals(target));

        target.addItems(new ArrayList<>());

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsSameItemsInsideList() {
        item.addItem(new Item("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.addItem(new Item("1", "Title", "Desc"));

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsDiffItemsInsideList() {
        item.addItem(new Item("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.addItem(new Item("2", "Title", "Desc"));

        assertFalse(item.equals(target));
    }

    @Test
    public void testEqualsEmptyRelatedItemsList() {
        item.addRelatedItems(new ArrayList<>());

        assertFalse(item.equals(target));

        target.addRelatedItems(new ArrayList<>());

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsSameRelatedItemsInsideList() {
        item.addRelatedItem(new Item("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.addRelatedItem(new Item("1", "Title", "Desc"));

        assertTrue(item.equals(target));
    }

    @Test
    public void testEqualsDiffRelatedItemsInsideList() {
        item.addRelatedItem(new Item("1", "Title", "Desc"));

        assertFalse(item.equals(target));

        target.addRelatedItem(new Item("2", "Title", "Desc"));

        assertFalse(item.equals(target));
    }

    @Test
    public void testHashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        hashCodeBuilder
                .append(target.getKey())
                .append(target.getTitle())
                .append(target.getDescription())
                .append(target.getRelatedItems())
                .append(target.getItems())
                .append(target.getRange());

        assertEquals(target.hashCode(), hashCodeBuilder.toHashCode());
    }
}