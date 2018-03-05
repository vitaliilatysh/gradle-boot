package com.globallogic.dc.service.impl;

import com.globallogic.dc.commons.test.RangeBuilder;
import com.globallogic.dc.model.Range;
import com.globallogic.dc.repository.RangeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RangeServiceImplTest {

    @Mock
    private RangeDao rangeDao;

    @InjectMocks
    private RangeServiceImpl rangeService;

    @Test
    public void testGetRanges() {
        List<Range> ranges = new RangeBuilder().buildAllRanges();

        when(rangeDao.getAll()).thenReturn(ranges);

        assertEquals(6, rangeService.getRanges().size());
    }

    @Test
    public void testGetRangeById() {
        when(rangeDao.getById("41")).thenReturn(new Range("41", "Title", "Desc"));

        assertEquals("41", rangeService.getRangeById("41").getKey());
    }

    @Test
    public void testGetRangesBySubChapterId() {
        when(rangeDao.getRangesBySubChapterId("24")).thenReturn(Arrays.asList(
                new Range("44", "Title", "Desc"),
                new Range("45", "Title", "Desc")));

        assertEquals(2, rangeService.getRangesBySubChapterId("24").size());
    }

    @Test
    public void testGetRangesBySectionId() {
        when(rangeDao.getRangesBySectionId("31")).thenReturn(Arrays.asList(
                new Range("41", "Title", "Desc"),
                new Range("42", "Title", "Desc"),
                new Range("43", "Title", "Desc")));

        assertEquals(3, rangeService.getRangesBySectionId("31").size());
    }
}
