package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Item;
import com.globallogic.dc.repository.ItemDao;
import com.globallogic.dc.repository.fs.config.RepositoryConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class ItemDaoImplTest {

    @Mock
    private FileSystemConnectorImpl fileSystemConnector;

    @Mock
    private ItemDao itemDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testMockCreation() {
        assertNotNull(fileSystemConnector);
        assertNotNull(itemDao);
    }

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
