package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.repository.fs.config.DaoConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubChapterDaoImplTest {

    private AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DaoConfig.class);
    private SubChapterDaoImpl subChapterDaoImpl = container.getBean(SubChapterDaoImpl.class);

    @Test
    public void testGetSubChaptersByChapterId() {
        List<SubChapter> subChapters = subChapterDaoImpl.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
