package com.globallogic.dc.services.impl;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.repository.fs.impl.SubChapterDaoImpl;
import com.globallogic.dc.services.SubChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SubChapterServiceImpl.class, SubChapterDaoImpl.class, FileSystemConnectorImpl.class})
public class SubChapterServiceImplTest {

    @Autowired
    private SubChapterService subChapterService;

    @Test
    public void testGetSubChapters() {
        assertEquals(4, subChapterService.getSubChapters().size());
    }

    @Test
    public void testGetSubChapterById() {
        assertEquals("21", subChapterService.getSubChapterById("21").getKey());
    }

    @Test
    public void testGetSubChaptersByChapterId() {
        assertEquals(2, subChapterService.getSubChaptersByChapterId("12").size());
    }
}
