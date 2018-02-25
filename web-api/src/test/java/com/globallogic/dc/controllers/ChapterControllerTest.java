package com.globallogic.dc.controllers;

import com.globallogic.dc.config.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ChapterControllerTest {

    @Autowired
    private ChapterController chapterController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(chapterController)
                .build();
    }

    @Test
    public void testGetChapters() throws Exception {
        mockMvc.perform(get("/chapters"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].key", is("12")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("13")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")))
                .andExpect(jsonPath("$[2].key", is("14")))
                .andExpect(jsonPath("$[2].title", is("Title")))
                .andExpect(jsonPath("$[2].description", is("Desc")));
    }

    @Test
    public void testGetChapterById() throws Exception {
        mockMvc.perform(get("/chapters/12"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("12")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }
}