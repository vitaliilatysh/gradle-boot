package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemDaoImplTest {

    private List<String> items;

    @Mock
    private FileSystemConnector fileSystemConnector;

    @InjectMocks
    private ItemDaoImpl itemDao;

    @Before
    public void setUp() {
        items = new ArrayList<>();
        items.add("51,Title,Desc");
        items.add("52,Title,Desc");
        items.add("53,Title,Desc");
        items.add("54,Title,Desc");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItems() {
        when(fileSystemConnector.readFile("items.csv")).thenReturn(items);

        List<Item> items = itemDao.getAll();

        assertEquals(4, items.size());
    }

    @Test
    public void testGetItemById() {
        when(fileSystemConnector.readFile("items.csv")).thenReturn(items);

        Item item = itemDao.getById("52");

        assertEquals("52", item.getIdentifier());
        assertEquals("Title", item.getTitle());
        assertEquals("Desc", item.getDescription());
    }

    @Test
    public void testGetItemsByRangeId() {
        List<String> itemsToRanges = new ArrayList<>();
        itemsToRanges.add("51,41");
        itemsToRanges.add("52,41");
        itemsToRanges.add("53,42");

        when(fileSystemConnector.readFile("items.csv")).thenReturn(items);
        when(fileSystemConnector.readFile("itemsToRanges.csv")).thenReturn(itemsToRanges);

        List<Item> items = itemDao.getItemsByRangeId("41");

        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemsByRelatedItems() {
        List<String> itemsToRelatedItems = new ArrayList<>();
        itemsToRelatedItems.add("51,52");
        itemsToRelatedItems.add("52,54");
        itemsToRelatedItems.add("53,54");
        itemsToRelatedItems.add("54,51");

        when(fileSystemConnector.readFile("items.csv")).thenReturn(items);
        when(fileSystemConnector.readFile("itemsToRelatedItems.csv")).thenReturn(itemsToRelatedItems);

        List<Item> items = itemDao.getItemsByRelatedItemId("54");

        assertEquals(2, items.size());
    }

    @Test
    public void testGetItemsByStringItems() {
        List<String> itemsToStringItems = new ArrayList<>();
        itemsToStringItems.add("51,Item1");
        itemsToStringItems.add("52,Item2");
        itemsToStringItems.add("52,Item3");
        itemsToStringItems.add("54,Item1");

        when(fileSystemConnector.readFile("items.csv")).thenReturn(items);
        when(fileSystemConnector.readFile("itemsToStringItems.csv")).thenReturn(itemsToStringItems);

        List<Item> items = itemDao.getItemsByStringItemId("Item1");

        assertEquals(2, items.size());
    }
}
