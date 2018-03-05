package com.globallogic.dc.controllers;

import com.globallogic.dc.commons.test.SubChapterBuilder;
import com.globallogic.dc.model.SubChapter;
import com.globallogic.dc.service.SubChapterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class SubChapterControllerTest {

    @Mock
    private SubChapterService subChapterService;

    @InjectMocks
    private SubChapterController subChapterController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(subChapterController)
                .build();
    }

    @Test
    public void testGetSubChapters() throws Exception {
        List<SubChapter> subChapters = new SubChapterBuilder().buildAllSubChapters();

        when(subChapterService.getSubChapters()).thenReturn(subChapters);
        mockMvc.perform(get("/subChapters"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].key", is("21")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("22")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")))
                .andExpect(jsonPath("$[2].key", is("23")))
                .andExpect(jsonPath("$[2].title", is("Title")))
                .andExpect(jsonPath("$[2].description", is("Desc")))
                .andExpect(jsonPath("$[3].key", is("24")))
                .andExpect(jsonPath("$[3].title", is("Title")))
                .andExpect(jsonPath("$[3].description", is("Desc")));
    }

    @Test
    public void testGetSubChapterById() throws Exception {
        when(subChapterService.getSubChapterById("21")).thenReturn(new SubChapter("21", "Title", "Desc"));

        mockMvc.perform(get("/subChapters/21"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("21")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }

    @Test
    public void testGetSubChaptersByChapterId() throws Exception {
        when(subChapterService.getSubChaptersByChapterId("12")).thenReturn(Arrays.asList(
                new SubChapter("21", "Title", "Desc"),
                new SubChapter("22", "Title", "Desc")));

        mockMvc.perform(get("/subChapters?chapter=12"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("21")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("22")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")));
    }
}
