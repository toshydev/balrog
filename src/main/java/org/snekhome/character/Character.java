package org.snekhome.character;

import java.util.UUID;

public abstract class Character {
    public int posX;
    public int posY;
    private int hitPoints;
    public boolean isAlive;
    public final UUID id;
    public String description;
    public Character(String description) {
        this.description = description;
        this.id = UUID.randomUUID();
        this.hitPoints = 100;
    }
    public Character(String description, int hp) {
        this(description);
        this.hitPoints = hp;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hp) {
        this.hitPoints = hp;
    }

    public void checkHP() {
        if (this.getHitPoints() <= 0) {
            this.die();
        }
    }
    public abstract void die();
}
