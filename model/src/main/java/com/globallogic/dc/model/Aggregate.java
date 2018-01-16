package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Aggregate {

    protected abstract void doEquals(final EqualsBuilder equalsBuilder, final Entity obj);

    protected abstract void doHashCode(final HashCodeBuilder hashCodeBuilder);

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (obj.getClass() != getClass()) {
            return false;
        }
        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        doEquals(equalsBuilder, (Entity) obj);
        return equalsBuilder.isEquals();
    }

    @Override
    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(17, 37);
        doHashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }
}
