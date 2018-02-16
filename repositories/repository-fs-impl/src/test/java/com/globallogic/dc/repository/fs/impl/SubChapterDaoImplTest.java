package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.SubChapter;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SubChapterDaoImplTest {

    private SubChapterDaoImpl subChapterDaoImpl = SubChapterDaoImpl.getInstance();

    @Test
    public void testGetSubChaptersByChapterId() {
        List<SubChapter> subChapters = subChapterDaoImpl.getSubChaptersByChapterId("12");

        assertEquals(2, subChapters.size());
    }
}
