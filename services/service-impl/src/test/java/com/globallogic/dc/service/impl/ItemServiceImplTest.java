package com.globallogic.dc.service.impl;

import com.globallogic.dc.service.ItemService;
import com.globallogic.dc.service.config.ServiceConfig;
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
    private ItemService itemService;

    @Test
    public void testGetChapters() {
        assertEquals(4, itemService.getItems().size());
    }

    @Test
    public void testGetChapterById() {
        assertEquals("51", itemService.getItemById("51").getKey());
    }

    @Test
    public void testGetItemsByRelatedItemId() {
        assertEquals(2, itemService.getItemsByRelatedItemId("54").size());
    }

    @Test
    public void testGetItemsByStringItemId() {
        assertEquals(2, itemService.getItemsByStringItemId("Item1").size());
    }

    @Test
    public void testGetItemsByRangeId() {
        assertEquals(2, itemService.getItemsByRangeId("41").size());
    }
}
