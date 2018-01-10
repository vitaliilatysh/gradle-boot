package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractProductBaseTest {

    Chapter chapter;

    @Before
    public void setUpTestObject() {
        chapter = new Chapter("1", "Title", "Desc");
    }

    @Test
    public void getKey() {
        assertEquals("1", chapter.getKey());
    }

    @Test
    public void setKey() {
        chapter.setKey("2");
        assertEquals("2", chapter.getKey());
    }

    @Test
    public void hasKey() {
        assertTrue(chapter.hasKey());
    }

    @Test
    public void hasKey_NullKey() {
        chapter.setKey(null);
        assertFalse(chapter.hasKey());
    }

    @Test
    public void hasKey_EmptyKey() {
        chapter.setKey("");
        assertFalse(chapter.hasKey());
    }

    @Test
    public void getTitle() {
        assertEquals("Title", chapter.getTitle());
    }

    @Test
    public void setTitle() {
        chapter.setTitle("TitleNew");
        assertEquals("TitleNew", chapter.getTitle());
    }

    @Test
    public void hasTitle() {
        assertTrue(chapter.hasTitle());
    }

    @Test
    public void hasTitle_NullTitle() {
        chapter.setTitle(null);
        assertFalse(chapter.hasTitle());
    }

    @Test
    public void hasTitle_EmptyTitle() {
        chapter.setTitle("");
        assertFalse(chapter.hasTitle());
    }

    @Test
    public void getDescription() {
        assertEquals("Desc", chapter.getDescription());
    }

    @Test
    public void setDescription() {
        chapter.setDescription("DescNew");
        assertEquals("DescNew", chapter.getDescription());
    }

    @Test
    public void hasDescription() {
        assertTrue(chapter.hasDescription());
    }

    @Test
    public void hasDescription_NullDescription() {
        chapter.setDescription(null);
        assertFalse(chapter.hasDescription());
    }

    @Test
    public void hasDescription_EmptyDescription() {
        chapter.setDescription(" ");
        assertFalse(chapter.hasDescription());
    }
}
