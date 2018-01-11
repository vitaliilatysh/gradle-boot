package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class RangeTest {

    private Range target;
    private List<Item> items;
    private Item item;

    @Before
    public void initParameters() {
        item = new Item("11", "SubChapTitle11", "SubChapDesc11");
        items = new ArrayList<>();
        items.add(item);
    }

    @Before
    public void init() {
        target = new Range("1", "Title", "Desc", items) {
        };
    }

    @Test
    public void hasItems() {
        assertTrue(target.hasItems());

        items.remove(item);
        assertFalse(target.hasItems());

        target.setItems(null);
        assertFalse(target.hasItems());

        target = new Range("2", "Title2", "Desc2") {
        };
        assertFalse(target.hasItems());
    }

    @Test
    public void addItems() {
        target.addItems(items);
        assertThat(target.getItems().size(), is(2));

        target.addItems(null);
        assertThat(target.getItems().size(), is (2));

        items.clear();
        target.addItems(items);
        assertThat(target.getItems().size(), is (0));
    }

    @Test
    public void addItem() {
        target.addItem(new Item("15", "Title15", "Desc15"));
        assertThat(target.getItems().size(), is(2));

        target.addItem(null);
        assertThat(target.getItems().size(), is (2));
    }

}