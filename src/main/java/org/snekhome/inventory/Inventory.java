package org.snekhome.inventory;

import java.util.Arrays;

public class Inventory {
    private Item[] items;

    public Inventory() {
        this.items = new Item[0];
    }

    public Item[] getItems() {
        return items;
    }

    public void add(Item itemToAdd) {
        Item[] newInventory = new Item[items.length + 1];
        System.arraycopy(items, 0, newInventory, 0, items.length);
        newInventory[items.length] = itemToAdd;
        items = newInventory;
    }

    public void remove(Item itemToRemove) {
        Item[] newInventory = new Item[items.length - 1];
        int idx = 0;
        while (idx < newInventory.length) {
            for (Item item : items) {
                if (!item.equals(itemToRemove)) {
                    newInventory[idx] = item;
                    idx++;
                }
            }
        }
        items = newInventory;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
