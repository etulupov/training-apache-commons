package com.noveogroup.tulupov.commons.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.digester3.annotations.rules.BeanPropertySetter;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Channel model.
 */
@SuppressWarnings("UnusedDeclaration")
@ObjectCreate(pattern = "rss/channel")
public class RssChannel implements Comparable<RssChannel> {
    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/title")
    private String title;

    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/link")
    private String link;

    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/description")
    private String description;

    @Getter
    @Setter
    @BeanPropertySetter(pattern = "rss/channel/language")
    private String language;

    @SuppressWarnings({ "MismatchedQueryAndUpdateOfCollection", "CanBeFinal" })
    @Getter
    @Setter
    private List<Item> items = new ArrayList<Item>();

    @SetNext
    public void addItem(final Item item) {
        this.items.add(item);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(final RssChannel obj) {
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
