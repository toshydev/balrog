package org.snekhome.character;

public class Enemy extends Npc {
    public Enemy(String description) {
        super(description);
    }

    @Override
    public void die() {
        System.out.println(this.description + " dies...");
        this.isAlive = false;
    }
}
