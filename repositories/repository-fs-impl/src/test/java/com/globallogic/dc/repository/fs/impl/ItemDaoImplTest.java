package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ItemDaoImpl.class, FileSystemConnectorImpl.class})
public class ItemDaoImplTest {

    @Autowired
    private ItemDaoImpl itemDaoImpl;

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
