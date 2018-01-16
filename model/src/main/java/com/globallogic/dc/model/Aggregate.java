package com.globallogic.dc.model;

public abstract class Aggregate {

    protected abstract boolean doEquals(final Object obj);

    protected abstract int doHashCode();

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        return doEquals(obj);
    }

    @Override
    public int hashCode() {
        return doHashCode();
    }
}
