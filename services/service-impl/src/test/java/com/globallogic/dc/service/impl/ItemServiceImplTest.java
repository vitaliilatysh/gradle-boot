package com.globallogic.dc.service.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
        List<Item> items = new ArrayList<>();
        items.add(new Item("51", "Title", "Desc"));
        items.add(new Item("52", "Title", "Desc"));
        items.add(new Item("53", "Title", "Desc"));
        items.add(new Item("54", "Title", "Desc"));

        when(itemDao.getAll()).thenReturn(items);

        assertEquals(4, itemService.getItems().size());
    }

    @Test
    public void testGetItemById() {
        when(itemDao.getById("51")).thenReturn(new Item("51", "Title", "Desc"));

        assertEquals("51", itemService.getItemById("51").getKey());
    }

    @Test
    public void testGetItemsByRelatedItemId() {
        when(itemDao.getItemsByRelatedItemId("54")).thenReturn(Arrays.asList(
                new Item("52", "Title", "Desc"),
                new Item("53", "Title", "Desc")));

        assertEquals(2, itemService.getItemsByRelatedItemId("54").size());
    }

    @Test
    public void testGetItemsByStringItemId() {
        when(itemDao.getItemsByStringItemId("Item1")).thenReturn(Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("54", "Title", "Desc")));

        assertEquals(2, itemService.getItemsByStringItemId("Item1").size());
    }

    @Test
    public void testGetItemsByRangeId() {
        when(itemDao.getItemsByRangeId("41")).thenReturn(Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("52", "Title", "Desc")));

        assertEquals(2, itemService.getItemsByRangeId("41").size());
    }
}
