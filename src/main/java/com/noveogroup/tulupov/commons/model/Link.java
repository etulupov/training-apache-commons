package com.noveogroup.tulupov.commons.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Link model.
 */
@Builder
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
public class Link implements Comparable<Link> {
    @Getter
    @Setter
    private String location;

    @Override
    public int compareTo(final Link obj) {
        return CompareToBuilder.reflectionCompare(this, obj);
    }

    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
