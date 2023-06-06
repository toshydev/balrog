package org.snekhome.inventory;

import org.snekhome.environment.Type;

import java.util.Objects;

public class Item {
    public String description;
    public Type type;
    public boolean usable;

    public Item(String description, Type type) {
        this.description = description;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(description, item.description) && type == item.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, type);
    }

    @Override
    public String toString() {
        return this.description;
    }
}
