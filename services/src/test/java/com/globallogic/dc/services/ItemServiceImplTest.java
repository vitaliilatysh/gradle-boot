package com.globallogic.dc.services;

import com.globallogic.dc.services.config.ServiceConfig;
import com.globallogic.dc.services.impl.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class ItemServiceImplTest {

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @Test
    public void testGetChapters() {
        assertEquals(4, itemServiceImpl.getItems().size());
    }

    @Test
    public void testGetChapterById() {
        assertEquals("51", itemServiceImpl.getItemById("51").getKey());
    }

    @Test
    public void testGetItemsByRelatedItemId() {
        assertEquals(2, itemServiceImpl.getItemsByRelatedItemId("54").size());
    }

    @Test
    public void testGetItemsByStringItemId() {
        assertEquals(2, itemServiceImpl.getItemsByStringItemId("Item1").size());
    }

    @Test
    public void testGetItemsByRangeId() {
        assertEquals(2, itemServiceImpl.getItemsByRangeId("41").size());
    }
}
