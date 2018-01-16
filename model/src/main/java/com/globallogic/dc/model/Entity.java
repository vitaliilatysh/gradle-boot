package com.globallogic.dc.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Entity <T> extends Aggregate implements Identifiable <T> {

    @Override
    protected void doEquals(final EqualsBuilder equalsBuilder, final Entity obj){
        equalsBuilder
                .append(this.getIdentifier(), obj.getIdentifier());
    }

    @Override
    protected  void doHashCode(final HashCodeBuilder hashCodeBuilder){
        hashCodeBuilder
                .append(getIdentifier());
    }
}
