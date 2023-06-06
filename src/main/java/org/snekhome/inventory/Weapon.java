package org.snekhome.inventory;

import org.snekhome.environment.Type;

public class Weapon extends Item {
    public int attackPoints;
    public Weapon(String description, int ap) {
        super(description, Type.WEAPON);
        this.attackPoints = ap;
        this.usable = false;
    }
}
