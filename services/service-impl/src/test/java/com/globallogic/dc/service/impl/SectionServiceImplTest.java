package com.globallogic.dc.service.impl;

import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.repository.api.SectionDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SectionServiceImplTest {

    @Mock
    private SectionDao sectionDao;

    @InjectMocks
    private SectionServiceImpl sectionService;

    @Test
    public void testGetSections() {
        when(sectionDao.getAll()).thenReturn(new SectionBuilder().buildAllSections());

        assertEquals(4, sectionService.getSections().size());
    }

    @Test
    public void testGetSectionById() {
        when(sectionDao.getById("31")).thenReturn(new Section("31", "Title", "Desc"));

        assertEquals("31", sectionService.getSectionById("31").getKey());
    }

    @Test
    public void testGetSectionsBySubChapterId() {
        when(sectionDao.getSectionsBySubChapterId("22")).thenReturn(Arrays.asList(
                new Section("32", "Title", "Desc"),
                new Section("33", "Title", "Desc")));

        assertEquals(2, sectionService.getSectionsBySubChapterId("22").size());
    }
}
