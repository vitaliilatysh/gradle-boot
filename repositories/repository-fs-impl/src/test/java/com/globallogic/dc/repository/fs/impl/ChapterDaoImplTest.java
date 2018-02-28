package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.repository.ChapterDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChapterDaoImplTest {

    @Mock
    private ChapterDao chapterDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetChapters() {
        when(chapterDao.getAll()).thenReturn(Arrays.asList(
                new Chapter("12", "Title", "Desc"),
                new Chapter("13", "Title", "Desc"),
                new Chapter("14", "Title", "Desc")));

        List<Chapter> chapters = chapterDao.getAll();

        assertEquals(3, chapters.size());
    }

    @Test
    public void testGetChapterById() {
        when(chapterDao.getById("12")).thenReturn(
                new Chapter("12", "Title", "Desc"));
        Chapter chapter = chapterDao.getById("12");

        assertEquals("12", chapter.getIdentifier());
        assertEquals("Title", chapter.getTitle());
        assertEquals("Desc", chapter.getDescription());
    }
}
