package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.config.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class ItemDaoImplTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testGetItemsByRangeId() {
        List<Item> items = itemDao.getItemsByRangeId("41");

        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemsByRelatedItems() {
        List<Item> items = itemDao.getItemsByRelatedItemId("54");

        assertEquals(2, items.size());

    }

    @Test
    public void testGetItemsByStringItems() {
        List<Item> items = itemDao.getItemsByStringItemId("Item1");

        assertEquals(2, items.size());

    }
}
