package com.globallogic.dc.model;

import com.globallogic.dc.commons.test.ItemBuilder;
import com.globallogic.dc.commons.test.RangeBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    private Item target;

    @Before
    public void setUp() {
        target = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
    }

    @Test
    public void testSetRange_NoRangeInItem() {
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        target.setRange(range);

        assertTrue(target.hasRange());
        assertTrue(target.getRange().equals(range));
        assertTrue(range.containsItem(target));
        assertEquals(1, range.getItems().size());
    }

    @Test
    public void testSetRange_MoveRangeToAnotherItem() {
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item target = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withRange(range)
                .build();
        final Item anotherItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();


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
        final Item relatedItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item target = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withRelatedItems(Collections.singletonList(relatedItem))
                .build();

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
        final Range range = new RangeBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item target = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withRange(range)
                .build();

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
        final Item anotherItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item target = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .withItems(Arrays.asList(anotherItem.toString()))
                .build();

        assertNotNull(target.getItems());
        assertTrue(target.hasItems());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRelatedItem_IllegalArgumentException() {
        target.addRelatedItem(null);
    }

    @Test
    public void testAddRelatedItem_NoRelatedItemInItem() {
        final Item relatedItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Item anotherItem = new ItemBuilder()
                .withKey("2")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item relatedItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Item relatedItem1 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item relatedItem2 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        target.addItem(null);
    }

    @Test
    public void testAddItem_NoItemInItem() {
        final Item anotherItem = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

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
        final Item item1 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();
        final Item item2 = new ItemBuilder()
                .withKey("1")
                .withTitle("Title")
                .withDescription("Desc")
                .build();

        final List<String> items = Arrays.asList(item1.toString(), item2.toString());

        target.addItems(items);

        assertTrue(target.hasItems());

        assertTrue(target.containsItem(item1.toString()));
        assertTrue(target.containsItem(item2.toString()));
    }
}