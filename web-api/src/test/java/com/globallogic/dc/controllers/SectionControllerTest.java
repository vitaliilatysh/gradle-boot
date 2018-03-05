package com.globallogic.dc.controllers;

import com.globallogic.dc.controllers.config.ControllerConfig;
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
@ContextConfiguration(classes = ControllerConfig.class)
public class SectionControllerTest {

    @Autowired
    private SectionController sectionController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(sectionController)
                .build();
    }

    @Test
    public void testGetSections() throws Exception {
        mockMvc.perform(get("/sections"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].key", is("31")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("32")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")))
                .andExpect(jsonPath("$[2].key", is("33")))
                .andExpect(jsonPath("$[2].title", is("Title")))
                .andExpect(jsonPath("$[2].description", is("Desc")))
                .andExpect(jsonPath("$[3].key", is("34")))
                .andExpect(jsonPath("$[3].title", is("Title")))
                .andExpect(jsonPath("$[3].description", is("Desc")));
    }

    @Test
    public void testGetSectionById() throws Exception {
        mockMvc.perform(get("/sections/31"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("31")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }

    @Test
    public void getSectionsBySubChapterId() throws Exception {
        mockMvc.perform(get("/sections?subChapter=22"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("32")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("33")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")));
    }
}