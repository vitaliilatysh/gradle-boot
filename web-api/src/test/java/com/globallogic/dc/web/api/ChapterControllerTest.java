package com.globallogic.dc.web.api;

import com.globallogic.dc.commons.test.ChapterBuilder;
import com.globallogic.dc.model.Chapter;
import com.globallogic.dc.service.ChapterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ChapterControllerTest {

    @Mock
    private ChapterService chapterService;

    @InjectMocks
    private ChapterController chapterController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(chapterController)
                .build();
    }

    @Test
    public void testGetChapters() throws Exception {
        List<Chapter> chapters = new ChapterBuilder().buildAllChapters();

        when(chapterService.getChapters()).thenReturn(chapters);

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
        when(chapterService.getChapterById("12")).thenReturn(new Chapter("12", "Title", "Desc"));

        mockMvc.perform(get("/chapters/12"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("12")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }
}