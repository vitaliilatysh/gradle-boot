package com.globallogic.dc.services.impl;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.fs.impl.ChapterDaoImpl;
import com.globallogic.dc.services.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ChapterServiceImpl.class, ChapterDaoImpl.class, FileSystemConnectorImpl.class})
public class ChapterServiceImplTest {

    @Autowired
    private ChapterService chapterService;

    @Test
    public void testGetChapters() {
        assertEquals(3, chapterService.getChapters().size());
    }

    @Test
    public void testGetChapterById() {
        assertEquals("12", chapterService.getChapterById("12").getKey());
    }
}
