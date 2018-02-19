package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.fs.config.DaoConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemDaoImplTest {

    private AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DaoConfig.class);
    private ItemDaoImpl itemDaoImpl = container.getBean(ItemDaoImpl.class);

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
