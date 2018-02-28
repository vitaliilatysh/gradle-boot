package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.SectionDao;
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
public class SectionDaoImplTest {

    @Mock
    private SectionDao sectionDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSections() {
        when(sectionDao.getAll()).thenReturn(Arrays.asList(
                new Section("31", "Title", "Desc"),
                new Section("32", "Title", "Desc"),
                new Section("33", "Title", "Desc"),
                new Section("34", "Title", "Desc")));
        List<Section> sections = sectionDao.getAll();

        assertEquals(4, sections.size());
    }

    @Test
    public void testGetSectionById() {
        when(sectionDao.getById("32")).thenReturn(
                new Section("32", "Title", "Desc"));
        Section section = sectionDao.getById("32");

        assertEquals("32", section.getIdentifier());
        assertEquals("Title", section.getTitle());
        assertEquals("Desc", section.getDescription());
    }

    @Test
    public void testGetSectionsBySubChapterId() {
        when(sectionDao.getSectionsBySubChapterId("22")).thenReturn(Arrays.asList(
                new Section("32", "Title", "Desc"),
                new Section("33", "Title", "Desc")));
        List<Section> sections = sectionDao.getSectionsBySubChapterId("22");

        assertEquals(2, sections.size());
    }
}
