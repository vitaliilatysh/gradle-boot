package com.globallogic.dc.model;

import java.util.List;

public class Item extends ItemBase {

    public Item(final String key, final String title, final String description) {
        super(key, title, description);
    }

    public Item(final String key, final String title, final String description, final Range range,
                final List<Item> items, final List<Item> relatedItems) {
        super(key, title, description, range, items, relatedItems);
    }

    public Item(final String key, final String title, final String description, final Range range,
                final List<Item> relatedItems) {
        super(key, title, description, range, relatedItems);
    }
}
