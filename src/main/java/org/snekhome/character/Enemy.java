package org.snekhome.character;

import org.snekhome.environment.Direction;
import org.snekhome.environment.Movement;
import org.snekhome.inventory.Gold;
import org.snekhome.inventory.Item;
import org.snekhome.inventory.Potion;

public class Enemy extends Npc implements Movement {
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

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case NORTH -> posY--;
            case EAST -> posX++;
            case SOUTH -> posY++;
            case WEST -> posX--;
        }
    }

    @Override
    public boolean checkCollision(Object object) {
        if (object instanceof Npc) {
            return this.posX == ((Npc) object).posX && this.posY == ((Npc) object).posY;
        }
        return false;
    }

    public static void main(String[] args) {
        Enemy enemy = new Enemy("Monster");
        enemy.posX = 2; enemy.posY = 2;
        Enemy enemy2 = new Enemy("Monster2");
        enemy2.posX = 2; enemy2.posY = 3;
        Player player = new Player("player");
        Potion health = new Potion("health potion", 15);
        System.out.println(enemy.checkCollision(enemy2));
    }
}
