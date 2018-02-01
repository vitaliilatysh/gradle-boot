package com.globallogic.dc.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testSetRange_NoRangeInItem() {
        final Item target = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");

        target.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.containsItem(target));
        assertEquals(1, range.getItems().size());
    }

    @Test
    public void testSetRange_MoveRangeToAnotherItem() {
        final Item target = buildItem(false, false, true);
        final Item anotherItem = buildItem(false, false, false);
        final Range range = new Range("1", "Title", "Desc");

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

    @Test(expected = IllegalArgumentException.class)
    public void testAddRelatedItem_IllegalArgumentException() {
        final Item target = buildItem(false, false, false);

        target.addRelatedItem(null);
    }

    @Test
    public void testAddRelatedItem_NoRelatedItemInItem() {
        final Item target = buildItem(false, false, false);
        final Item relatedItem = new Item("2", "Title", "Desc");

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
        final Item target = buildItem(false, false, false);
        final Item anotherItem = new Item("4", "Title", "Desc");
        final Item relatedItem = new Item("2", "Title", "Desc");

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
        final Item target = buildItem(false, false, false);

        target.addRelatedItems(null);
    }

    @Test
    public void testAddRelatedItems() {
        final Item target = buildItem(false, false, false);

        final Item relatedItem1 = new Item("2", "Title", "Desc");
        final Item relatedItem2 = new Item("2", "Title", "Desc");

        target.addRelatedItems(Arrays.asList(relatedItem1, relatedItem2));

        assertTrue(target.hasRelatedItems());

        assertTrue(target.containsRelatedItem(relatedItem1));
        assertTrue(target.containsRelatedItem(relatedItem2));

        assertTrue(relatedItem1.hasRelatedItems());
        assertTrue(relatedItem2.hasRelatedItems());

        assertTrue(relatedItem1.containsRelatedItem(target));
        assertTrue(relatedItem2.containsRelatedItem(target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItem_IllegalArgumentException() {
        final Item target = buildItem(false, false, false);

        target.addItem(null);
    }

    @Test
    public void testAddItem_NoItemInItem() {
        final Item target = buildItem(false, false, false);
        final Item anotherItem = new Item("2", "2", "2");

        target.addItem(anotherItem.toString());

        assertTrue(target.hasItems());
        assertTrue(target.containsItem(anotherItem.toString()));
        assertEquals(1, target.getItems().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItems_IllegalArgumentException() {
        final Item target = buildItem(false, false, false);

        target.addItems(null);
    }

    @Test
    public void testAddItems() {
        final Item target = buildItem(false, false, false);
        final Item item1 = buildItem(false, false, false);
        final Item item2 = buildItem(false, false, false);

        final List<String> items = Arrays.asList(item1.toString(), item2.toString());

        target.addItems(items);

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(item1.toString()));
        assertTrue(target.containsItem(item2.toString()));
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
                    new Item("1", "Title", "Desc").toString(),
                    new Item("2", "Title", "Desc").toString()));
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