package org.snekhome.character;

public class Enemy extends Npc {
    public Enemy(String description) {
        super(description);
    }

    public Enemy(String description, int hp) {
        super(description);
        this.setHitPoints(hp);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", isAlive=" + isAlive +
                ", HP=" + this.getHitPoints() +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public void die() {
        System.out.println(this.description + " dies...");
        this.isAlive = false;
    }
}
