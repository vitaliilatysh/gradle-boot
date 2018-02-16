package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemDaoImplTest {

    private ItemDaoImpl itemDaoImpl = ItemDaoImpl.getInstance();

    @Test
    public void testGetItemsByRangeId() {
        List<Item> items = itemDaoImpl.getItemsByRangeId("41");

        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemsByRelatedItems() {
        List<Item> items = itemDaoImpl.getItemsByRelatedItemId("54");

        assertEquals(2, items.size());

    }

    @Test
    public void testGetItemsByStringItems() {
        List<Item> items = itemDaoImpl.getItemsByStringItemId("Item1");

        assertEquals(2, items.size());

    }
}
