package org.snekhome.inventory;

import org.snekhome.environment.Type;

public class Potion extends Item {
    public int hpChange;
    public Potion(String description, int hpChange) {
        super(description, Type.POTION);
        this.hpChange = hpChange;
        this.usable = true;
    }
}
