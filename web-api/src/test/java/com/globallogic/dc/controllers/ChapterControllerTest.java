package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChapterController.class)
public class ChapterControllerTest {

    @Autowired
    private ChapterController chapterController;


    @Test
    public void testGetChapters() {
        List<Chapter> chapterList = chapterController.getAllChapters();
    }
}