package com.globallogic.dc.controllers;

import com.globallogic.dc.model.Range;
import com.globallogic.dc.service.RangeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class RangeControllerTest {

    @Mock
    private RangeService rangeService;

    @InjectMocks
    private RangeController rangeController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(rangeController)
                .build();
    }

    @Test
    public void testGetRanges() throws Exception {
        List<Range> ranges = new ArrayList<>();
        ranges.add(new Range("41", "Title", "Desc"));
        ranges.add(new Range("42", "Title", "Desc"));
        ranges.add(new Range("43", "Title", "Desc"));
        ranges.add(new Range("44", "Title", "Desc"));

        when(rangeService.getRanges()).thenReturn(ranges);

        mockMvc.perform(get("/ranges"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].key", is("41")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("42")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")))
                .andExpect(jsonPath("$[2].key", is("43")))
                .andExpect(jsonPath("$[2].title", is("Title")))
                .andExpect(jsonPath("$[2].description", is("Desc")))
                .andExpect(jsonPath("$[3].key", is("44")))
                .andExpect(jsonPath("$[3].title", is("Title")))
                .andExpect(jsonPath("$[3].description", is("Desc")));
    }

    @Test
    public void testGetRangeById() throws Exception {
        when(rangeService.getRangeById("41")).thenReturn(new Range("41", "Title", "Desc"));

        mockMvc.perform(get("/ranges/41"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("41")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }

    @Test
    public void testGetRangesBySubChapterId() throws Exception {
        when(rangeService.getRangesBySubChapterId("24")).thenReturn(Arrays.asList(
                new Range("44", "Title", "Desc"),
                new Range("45", "Title", "Desc")));

        mockMvc.perform(get("/ranges?subChapter=24"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("44")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("45")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")));
    }

    @Test
    public void testGetRangesBySectionId() throws Exception {
        when(rangeService.getRangesBySectionId("31")).thenReturn(Arrays.asList(
                new Range("41", "Title", "Desc"),
                new Range("42", "Title", "Desc")));

        mockMvc.perform(get("/ranges?section=31"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("41")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("42")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")));
    }
}