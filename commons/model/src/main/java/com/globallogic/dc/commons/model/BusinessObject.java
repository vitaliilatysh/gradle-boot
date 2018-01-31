package com.globallogic.dc.commons.model;

public abstract class BusinessObject implements Formattable {

    @Override
    public String asFormattedString() {
        return getClass().getSimpleName();
    }

    @Deprecated
    public String toString() {
        return super.toString();
    }
}
