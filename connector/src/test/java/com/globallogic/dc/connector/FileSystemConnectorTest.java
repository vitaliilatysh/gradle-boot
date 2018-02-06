package com.globallogic.dc.connector;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileSystemConnectorTest {

    private FileSystemConnector fileSystemConnector = FileSystemConnector.getInstance();

    @Test
    public void testGetChapters() {
        assertEquals(3, fileSystemConnector.getChapters().size());
    }

}
