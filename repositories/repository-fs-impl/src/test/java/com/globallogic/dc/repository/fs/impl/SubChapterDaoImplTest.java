package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.config.AppConfig;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class SubChapterDaoImplTest {

    @Autowired
    private SubChapterDao subChapterDaoImpl;

    @Test
    public void testGetSubChaptersByChapterId() {
        List<SubChapter> subChapters = subChapterDaoImpl.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
