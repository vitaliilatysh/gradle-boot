package com.globallogic.dc.dao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChapterDaoImplTest {

    private ChapterDaoImpl chapterDaoImpl = ChapterDaoImpl.getInstance();

    @Test
    public void testGetChapters() {
        assertEquals(3, chapterDaoImpl.getChapters().size());
    }
}
