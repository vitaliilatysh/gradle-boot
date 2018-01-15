package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ItemTest {

    private Item target;

    @Before
    public void setup() {
        target = new Item("1", "Title", "Desc");
    }

    @Test
    public void testHasRelatedItems(){
        assertNull(target.getRelatedItems());
        assertFalse(target.hasRelatedItems());

        target.addRelatedItems(new ArrayList<>());

        assertFalse(target.hasRelatedItems());

        target.addRelatedItem(new Item("2", "2", "2"));

        assertNotNull(target.getRelatedItems());
        assertTrue(target.hasRelatedItems());

    }

    @Test
    public void testHasRange(){
        assertNull(target.getRange());
        assertFalse(target.hasRange());

        target.setRange(new Range("1", "Title", "Desc"));

        assertNotNull(target.getRange());
        assertTrue(target.hasRange());
    }

    @Test
    public void testHasItems(){
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
}