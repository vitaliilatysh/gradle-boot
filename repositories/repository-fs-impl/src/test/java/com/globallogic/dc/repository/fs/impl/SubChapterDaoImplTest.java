package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.SubChapterDao;
import com.globallogic.dc.repository.fs.config.RepositoryConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class SubChapterDaoImplTest {

    @Autowired
    private SubChapterDao subChapterDao;

    @Test
    public void testGetSubChaptersByChapterId() {
        List<SubChapter> subChapters = subChapterDao.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
