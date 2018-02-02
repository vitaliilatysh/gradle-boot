package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ItemBuilder;
import com.globallogic.dc.commons.test.RangeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    private final Item target = new ItemBuilder().buildDefault();
    private final Item anotherItem = new ItemBuilder().buildDefault();
    private final Item item1 = new ItemBuilder().buildDefault();
    private final Item item2 = new ItemBuilder().buildDefault();
    private final Item relatedItem = new ItemBuilder().buildDefault();
    private final Item anotherRelatedItem = new ItemBuilder().buildDefault();
    private final Range range = new RangeBuilder().buildDefault();

    @Test
    public void testSetRange_NoRangeInItem() {
        target.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.containsItem(target));
        assertEquals(1, range.getItems().size());
    }

    @Test
    public void testSetRange_MoveRangeToAnotherItem() {
        target.setRange(range);
        anotherItem.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.containsItem(target));
        assertTrue(anotherItem.hasRange());
        assertTrue(anotherItem.getRange().equals(range));
        assertTrue(range.containsItem(anotherItem));
        assertEquals(2, range.getItems().size());
    }

    @Test
    public void testHasRelatedItems_Empty() {
        assertNull(target.getRelatedItems());
        assertFalse(target.hasRelatedItems());

        target.addRelatedItems(new ArrayList<>());

        assertFalse(target.hasRelatedItems());
    }

    @Test
    public void testHasRelatedItems() {
        target.setRelatedItems(Collections.singletonList(relatedItem));

        assertNotNull(target.getRelatedItems());
        assertTrue(target.hasRelatedItems());
    }

    @Test
    public void testHasRange_NotSet() {
        assertNull(target.getRange());
        assertFalse(target.hasRange());
    }

    @Test
    public void testHasRange() {
        target.setRange(range);

        assertNotNull(target.getRange());
        assertTrue(target.hasRange());
    }

    @Test
    public void testHasItems_Empty() {
        assertNull(target.getItems());
        assertFalse(target.hasItems());

        target.addItems(new ArrayList<>());

        assertFalse(target.hasItems());
    }

    @Test
    public void testHasItems() {
        target.setItems(Collections.singletonList(anotherItem.toString()));

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRelatedItem_IllegalArgumentException() {
        target.addRelatedItem(null);
    }

    @Test
    public void testAddRelatedItem_NoRelatedItemInItem() {
        target.addRelatedItem(relatedItem);

        assertTrue(target.hasRelatedItems());
        assertTrue(relatedItem.hasRelatedItems());

        assertTrue(target.containsRelatedItem(relatedItem));
        assertTrue(relatedItem.containsRelatedItem(target));

        assertEquals(1, target.getRelatedItems().size());
        assertEquals(1, relatedItem.getRelatedItems().size());
    }

    @Test
    public void testAddRelatedItem_MoveRelatedItemToAnotherItem() {
        anotherItem.setKey("2");

        target.addRelatedItem(relatedItem);
        anotherItem.addRelatedItem(relatedItem);

        assertTrue(target.hasRelatedItems());

        assertTrue(anotherItem.hasRelatedItems());
        assertTrue(relatedItem.hasRelatedItems());

        assertTrue(target.containsRelatedItem(relatedItem));
        assertTrue(relatedItem.containsRelatedItem(target));
        assertTrue(anotherItem.containsRelatedItem(relatedItem));

        assertEquals(1, target.getRelatedItems().size());
        assertEquals(1, anotherItem.getRelatedItems().size());
        assertEquals(2, relatedItem.getRelatedItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRelatedItems_IllegalArgumentException() {
        target.addRelatedItems(null);
    }

    @Test
    public void testAddRelatedItems() {
        target.addRelatedItems(Arrays.asList(relatedItem, anotherRelatedItem));

        assertTrue(target.hasRelatedItems());

        assertTrue(target.containsRelatedItem(relatedItem));
        assertTrue(target.containsRelatedItem(anotherRelatedItem));

        assertTrue(relatedItem.hasRelatedItems());
        assertTrue(anotherRelatedItem.hasRelatedItems());

        assertTrue(relatedItem.containsRelatedItem(target));
        assertTrue(anotherRelatedItem.containsRelatedItem(target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItem_IllegalArgumentException() {
        target.addItem(null);
    }

    @Test
    public void testAddItem_NoItemInItem() {
        target.addItem(anotherItem.toString());

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(anotherItem.toString()));
        assertEquals(1, target.getItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItems_IllegalArgumentException() {
        target.addItems(null);
    }

    @Test
    public void testAddItems() {
        final List<String> items = Arrays.asList(item1.toString(), item2.toString());

        target.addItems(items);

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(item1.toString()));
        assertTrue(target.containsItem(item2.toString()));
    }
}