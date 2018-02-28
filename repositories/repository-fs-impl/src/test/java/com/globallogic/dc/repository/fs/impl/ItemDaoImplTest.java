package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoImplTest {

    @Mock
    private ItemDao itemDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItems() {
        when(itemDao.getAll()).thenReturn(Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("52", "Title", "Desc"),
                new Item("53", "Title", "Desc"),
                new Item("54", "Title", "Desc")));
        List<Item> items = itemDao.getAll();

        assertEquals(4, items.size());
    }

    @Test
    public void testGetItemById() {
        when(itemDao.getById("52")).thenReturn(
                new Item("52", "Title", "Desc"));
        Item item = itemDao.getById("52");

        assertEquals("52", item.getIdentifier());
        assertEquals("Title", item.getTitle());
        assertEquals("Desc", item.getDescription());
    }

    @Test
    public void testGetItemsByRangeId() {
        when(itemDao.getItemsByRangeId("41")).thenReturn(Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("52", "Title", "Desc")));
        List<Item> items = itemDao.getItemsByRangeId("41");

        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemsByRelatedItems() {
        when(itemDao.getItemsByRelatedItemId("54")).thenReturn(Arrays.asList(
                new Item("52", "Title", "Desc"),
                new Item("53", "Title", "Desc")));
        List<Item> items = itemDao.getItemsByRelatedItemId("54");

        assertEquals(2, items.size());

    }

    @Test
    public void testGetItemsByStringItems() {
        when(itemDao.getItemsByStringItemId("Item1")).thenReturn(Arrays.asList(
                new Item("51", "Title", "Desc"),
                new Item("54", "Title", "Desc")));
        List<Item> items = itemDao.getItemsByStringItemId("Item1");

        assertEquals(2, items.size());

    }
}
