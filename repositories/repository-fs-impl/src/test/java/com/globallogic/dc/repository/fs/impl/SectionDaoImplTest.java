package com.globallogic.dc.repository.fs.impl;

import com.globallogic.dc.connector.FileSystemConnectorImpl;
import com.globallogic.dc.model.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SectionDaoImpl.class, FileSystemConnectorImpl.class})
public class SectionDaoImplTest {

    @Autowired
    private SectionDaoImpl sectionDaoImpl;

    @Test
    public void testGetSectionsBySubChapterId() {
        List<Section> sections = sectionDaoImpl.getSectionsBySubChapterId("22");

        assertEquals(2, sections.size());
    }
}
