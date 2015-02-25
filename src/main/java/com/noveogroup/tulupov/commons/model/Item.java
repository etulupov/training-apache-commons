package com.noveogroup.tulupov.commons.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Item model.
 */
@SuppressWarnings({ "UnusedDeclaration", "WeakerAccess" })
@ObjectCreate(pattern = "rss/channel/item")
public class Item implements Comparable<Item> {
    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/item/title")
    private String title;

    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/item/link")
    private String link;

    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/item/description")
    private String description;

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(final Item obj) {
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
