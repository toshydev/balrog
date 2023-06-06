package org.snekhome.inventory;

import org.snekhome.environment.Type;

public class Armor extends Item {
    public int armorPoints;
    public Armor(String description, int ap) {
        super(description, Type.ARMOR);
        this.armorPoints = ap;
        this.usable = false;
    }
}
