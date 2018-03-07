package com.globallogic.dc.web.api;

import com.globallogic.dc.commons.test.SectionBuilder;
import com.globallogic.dc.model.Section;
import com.globallogic.dc.service.SectionService;
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
public class SectionControllerTest {

    @Mock
    private SectionService sectionService;

    @InjectMocks
    private SectionController sectionController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(sectionController)
                .build();
    }

    @Test
    public void testGetSections() throws Exception {
        List<Section> sections = new SectionBuilder().buildAllSections();

        when(sectionService.getSections()).thenReturn(sections);

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
        when(sectionService.getSectionById("31")).thenReturn(new Section("31", "Title", "Desc"));

        mockMvc.perform(get("/sections/31"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("31")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }

    @Test
    public void testGetSectionsBySubChapterId() throws Exception {
        when(sectionService.getSectionsBySubChapterId("22")).thenReturn(Arrays.asList(
                new Section("32", "Title", "Desc"),
                new Section("33", "Title", "Desc")));

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