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
public class ItemControllerTest {

    @Autowired
    private ItemController itemController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(itemController)
                .build();
    }

    @Test
    public void testGetItems() throws Exception {
        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].key", is("51")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")))
                .andExpect(jsonPath("$[1].key", is("52")))
                .andExpect(jsonPath("$[1].title", is("Title")))
                .andExpect(jsonPath("$[1].description", is("Desc")))
                .andExpect(jsonPath("$[2].key", is("53")))
                .andExpect(jsonPath("$[2].title", is("Title")))
                .andExpect(jsonPath("$[2].description", is("Desc")))
                .andExpect(jsonPath("$[3].key", is("54")))
                .andExpect(jsonPath("$[3].title", is("Title")))
                .andExpect(jsonPath("$[3].description", is("Desc")));
    }

    @Test
    public void testGetItemById() throws Exception {
        mockMvc.perform(get("/items/51"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.key", is("51")))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.description", is("Desc")));
    }

    @Test
    public void getItemsByRelatedItemId() throws Exception {
        mockMvc.perform(get("/items?relatedItem=52"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("51")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")));
    }

    @Test
    public void getItemsByStringItemId() throws Exception {
        mockMvc.perform(get("/items?stringItem=Item1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("51")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")));
    }

    @Test
    public void getItemsByRangeId() throws Exception {
        mockMvc.perform(get("/items?range=42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].key", is("53")))
                .andExpect(jsonPath("$[0].title", is("Title")))
                .andExpect(jsonPath("$[0].description", is("Desc")));
    }
}