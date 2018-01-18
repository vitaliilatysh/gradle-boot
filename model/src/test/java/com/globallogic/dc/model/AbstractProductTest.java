package com.globallogic.dc.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractProductTest {

    @Test
    public void testGetIdentifier() {
        AbstractProduct abstractProduct = new AbstractProduct("1", "Title", "Desc") {};

        assertEquals("1", abstractProduct.getIdentifier());
    }
}
