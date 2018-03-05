package com.globallogic.dc.service.impl;

import com.globallogic.dc.service.RangeService;
import com.globallogic.dc.service.config.ServiceConfig;
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
    private RangeService rangeService;

    @Test
    public void testGetRanges() {
        assertEquals(6, rangeService.getRanges().size());
    }

    @Test
    public void testGetRangeById() {
        assertEquals("41", rangeService.getRangeById("41").getKey());
    }

    @Test
    public void testGetRangesBySubChapterId() {
        assertEquals(2, rangeService.getRangesBySubChapterId("24").size());
    }

    @Test
    public void testGetRangesBySectionId() {
        assertEquals(2, rangeService.getRangesBySectionId("31").size());
    }
}