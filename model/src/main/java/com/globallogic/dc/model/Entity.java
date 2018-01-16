package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Entity <T> extends Aggregate implements Identifiable <T> {

    @Override
    protected void doEquals(final EqualsBuilder equalsBuilder, final Object obj){
        equalsBuilder
                .append(getIdentifier(), getIdentifier());
    }

    @Override
    protected  void doHashCode(final HashCodeBuilder hashCodeBuilder){
        hashCodeBuilder
                .append(getIdentifier());
    }
}
