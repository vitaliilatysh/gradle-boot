package com.globallogic.dc.commons.test;

import com.globallogic.dc.model.Item;
import com.globallogic.dc.model.Range;

import java.util.Arrays;

public class ItemBuilder {

    public static Item buildItem(final boolean fillItems, final boolean fillRelatedItems, final boolean fillRange) {
        return buildItem("1", "Title", "Desc", fillItems, fillRelatedItems, fillRange);
    }

    private static Item buildItem(
            final String key,
            final String title,
            final String description,
            final boolean fillItems,
            final boolean fillRelatedItems,
            final boolean fillRange) {
        final Item result = new Item(key, title, description);

        if (fillItems) {
            result.addItems(Arrays.asList(
                    new Item("1", "Title", "Desc").getIdentifier(),
                    new Item("2", "Title", "Desc").getIdentifier()));
        }

        if (fillRelatedItems)
            result.addRelatedItems(Arrays.asList(
                    new Item("1", "Title", "Desc"),
                    new Item("2", "Title", "Desc")));

        if (fillRange)
            result.setRange(new Range("1", "Title", "Desc"));

        return result;
    }
}
