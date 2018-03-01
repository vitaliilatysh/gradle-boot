package com.globallogic.dc.service.impl;

import com.globallogic.dc.repository.ItemDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    @Mock
    private ItemDao itemDao;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItems() {
        assertEquals(4, itemService.getItems().size());
    }

    @Test
    public void testGetItemById() {
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
