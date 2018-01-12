package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

    private Item target;

    @Before
    public void setup() {
        target = new Item("1", "Title", "Desc");
    }

    @Test
    public void testAddRelatedItems() {
        assertFalse(target.hasRelatedItems());
        target.addRelatedItem(new Item("2", "2", "2"));
        assertTrue(target.hasRelatedItems());
        assertEquals(1, target.getRelatedItems().size());
    }

    @Test
    public void testAddRelatedItem() {
        assertFalse(target.hasRelatedItems());
        target.addRelatedItems(Arrays.asList(
                new Item("2", "2", "2"),
                new Item("3", "3", "3")));
        assertTrue(target.hasRelatedItems());
        assertEquals(2, target.getRelatedItems().size());
    }

    @Test
    public void testAddItems() {
        assertFalse(target.hasItems());
        target.addItem(new Item("2", "2", "2"));
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
}