package com.globallogic.dc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractProductTest {

    private final AbstractProduct abstractProduct = new AbstractProduct("1", "Title", "Desc") {
    };

    @Test
    public void testGetIdentifier() {
        assertEquals("1", abstractProduct.getIdentifier());
    }

    @Test
    public void testIsValid() {
        assertTrue(abstractProduct.isValid());
    }

    @Test
    public void testIsValid_IfInvalid() {
        abstractProduct.setKey(null);

        assertFalse(abstractProduct.isValid());
    }

    @Test
    public void testAsFormattedString() {
        assertEquals("1", abstractProduct.asFormattedString());
    }

    @Test
    public void testAsFormattedString_Empty() {
        abstractProduct.setKey(null);

        assertEquals("INVALID", abstractProduct.asFormattedString());
    }
}
