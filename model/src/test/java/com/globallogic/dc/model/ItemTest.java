package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class ItemTest {

    private Item target;
    private Range range;
    private List<Item> relatedItems;
    private Item relatedItem;

    @Before
    public void initParameters() {
        relatedItem = new Item("11", "ItemTitle11", "ItemDesc11");
        relatedItems = new ArrayList<>();
        relatedItems.add(relatedItem);

        range = new Range ("11", "RangeTitle", "RangeDesc");
    }

    @Before
    public void init() {
        target = new Item("1", "Title", "Desc", range, relatedItems) {
        };
    }
    @Test
    public void hasRelatedItems() {
        assertTrue(target.hasRelatedItems());

        relatedItems.remove(relatedItem);
        assertFalse(target.hasRelatedItems());

        target.setRelatedItems(null);
        assertFalse(target.hasRelatedItems());

        target = new Item("2", "Title2", "Desc2") {
        };
        assertFalse(target.hasRelatedItems());
    }

    @Test
    public void hasRange() {
        assertTrue(target.hasRange());

        target = new Item("2", "Title2", "Desc2");
        assertFalse(target.hasRange());

        target.setRange(null);
        assertFalse(target.hasRange());
    }

    @Test
    public void addRelatedItems() {
        target.addRelatedItems(relatedItems);
        assertThat(target.getRelatedItems().size(), is(2));

        target.addRelatedItems(null);
        assertThat(target.getRelatedItems().size(), is (2));

        relatedItems.clear();
        target.addRelatedItems(relatedItems);
        assertThat(target.getRelatedItems().size(), is (0));
    }

    @Test
    public void addRelatedItem() {
        target.addRelatedItem(new Item("15", "Title15", "Desc15"));
        assertThat(target.getRelatedItems().size(), is(2));

        target.addRelatedItem(null);
        assertThat(target.getRelatedItems().size(), is (2));
    }
}