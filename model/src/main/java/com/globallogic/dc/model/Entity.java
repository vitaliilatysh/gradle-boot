package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Entity <T> extends Aggregate implements Identifiable <T> {

    @Override
    protected void doEquals(final EqualsBuilder equalsBuilder, final Aggregate obj){
        final Identifiable identifier = (Identifiable) obj;
        equalsBuilder
                .append(this.getIdentifier(), identifier.getIdentifier());
    }

    @Override
    protected  void doHashCode(final HashCodeBuilder hashCodeBuilder){
        hashCodeBuilder
                .append(getIdentifier());
    }
}
