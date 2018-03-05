package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnector;
import com.globallogic.dc.model.Chapter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChapterDaoImplTest {

    private List<String> chapters;

    @Mock
    private FileSystemConnector fileSystemConnector;

    @InjectMocks
    private ChapterDaoImpl chapterDao;

    @Before
    public void setUp() {
        chapters = new ArrayList<>();
        chapters.add("12,Title,Desc");
        chapters.add("13,Title,Desc");
        chapters.add("14,Title,Desc");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetChapters() {
        when(fileSystemConnector.readFile("chapters.csv")).thenReturn(chapters);

        List<Chapter> chapters = chapterDao.getAll();

        assertEquals(3, chapters.size());
    }

    @Test
    public void testGetChapterById() {
        when(fileSystemConnector.readFile("chapters.csv")).thenReturn(chapters);

        Chapter chapter = chapterDao.getById("12");

        assertEquals("12", chapter.getIdentifier());
        assertEquals("Title", chapter.getTitle());
        assertEquals("Desc", chapter.getDescription());
    }
}
