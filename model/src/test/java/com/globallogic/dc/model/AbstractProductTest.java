package com.globallogic.dc.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractProductTest {

    private AbstractProduct target;

    @Before
    public void init() {
        target = new AbstractProduct("1", "Title", "Desc") {
        };
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
    public void hasTitle() {
        assertTrue(target.hasTitle());

        target.setTitle(null);
        assertFalse(target.hasTitle());

        target.setTitle("");
        assertFalse(target.hasTitle());
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
