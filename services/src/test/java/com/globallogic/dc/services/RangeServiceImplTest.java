package com.globallogic.dc.services;

import com.globallogic.dc.services.config.ServiceConfig;
import com.globallogic.dc.services.impl.RangeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class RangeServiceImplTest {

    @Autowired
    private RangeServiceImpl rangeServiceImpl;

    @Test
    public void testGetRanges() {
        assertEquals(6, rangeServiceImpl.getRanges().size());
    }

    @Test
    public void testGetRangeById() {
        assertEquals("41", rangeServiceImpl.getRangeById("41").getKey());
    }

    @Test
    public void testGetRangesBySubChapterId() {
        assertEquals(2, rangeServiceImpl.getRangesBySubChapterId("24").size());
    }

    @Test
    public void testGetRangesBySectionId() {
        assertEquals(2, rangeServiceImpl.getRangesBySectionId("31").size());
    }
}
