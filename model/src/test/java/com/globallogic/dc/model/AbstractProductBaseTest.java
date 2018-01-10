package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractProductBaseTest {

    private AbstractProductBase target;

    @Before
    public void init() {
        target = new AbstractProductBase("1", "Title", "Desc") {
        };
    }

    @Test
    public void getKey() {
        assertEquals("1", target.getKey());
    }

    @Test
    public void setKey() {
        target.setKey("2");
        assertEquals("2", target.getKey());
    }

    @Test
    public void hasKey() {
        assertTrue(target.hasKey());

        target.setKey(null);
        assertFalse(target.hasKey());

        target.setKey("");
        assertFalse(target.hasKey());
    }

    @Test
    public void getTitle() {
        assertEquals("Title", target.getTitle());
    }

    @Test
    public void setTitle() {
        target.setTitle("TitleNew");
        assertEquals("TitleNew", target.getTitle());
    }

    @Test
    public void hasTitle() {
        assertTrue(target.hasTitle());

        target.setTitle(null);
        assertFalse(target.hasTitle());

        target.setTitle("");
        assertFalse(target.hasTitle());
    }

    @Test
    public void getDescription() {
        assertEquals("Desc", target.getDescription());
    }

    @Test
    public void setDescription() {
        target.setDescription("DescNew");
        assertEquals("DescNew", target.getDescription());
    }

    @Test
    public void hasDescription() {
        assertTrue(target.hasDescription());

        target.setDescription(null);
        assertFalse(target.hasDescription());

        target.setDescription(" ");
        assertFalse(target.hasDescription());
    }

}
