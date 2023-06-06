package org.snekhome.character;

import org.snekhome.environment.Type;
import org.snekhome.inventory.*;

import java.util.Objects;

public class Player extends Character {
    public String playerName;
    private Inventory inventory;
    public int defense;
    public int attack;
    public int gold;

    public Player(String playerName) {
        super("Player");
        this.playerName = playerName;
        this.inventory = new Inventory();
        this.inventory.add(new Potion("Health Potion", 25));
        this.isAlive = true;
    }

    public Player(String playerName, int hitPoints) {
        this(playerName);
        this.setHitPoints(hitPoints);
    }

    @Override
    public void die() {
        System.out.println("Player " + playerName + " dies... RIP!");
        this.isAlive = false;
    }

    public void collect(Item item) {
        this.inventory.add(item);
        if (item.type == Type.WEAPON) {
            System.out.printf("%s picked up a %s%n", playerName, item);
            Weapon weapon = (Weapon) item;
            System.out.printf("%s's attack increases by %d points.", playerName, weapon.attackPoints);
            this.attack += weapon.attackPoints;
        }
        else if (item.type == Type.ARMOR) {
            System.out.printf("%s picked up a %s%n", playerName, item);
            Armor armor = (Armor) item;
            System.out.printf("%s's defense increases by %d points.", playerName, armor.armorPoints);
            this.defense += armor.armorPoints;
        }
        else if (item.type == Type.GOLD) {
            Gold gold = (Gold) item;
            System.out.printf("%s picked up %d Gold%n", playerName, gold.count);
            System.out.printf("%s's gold increases by %d points.", playerName, gold.count);
            this.gold += gold.count;
        }
    }

    public void use(Item item) {
        if (item.usable) {
            System.out.printf("%s used a %s%n", playerName, item);
            if (item.type == Type.POTION) {
                Potion potion = (Potion) item;
                System.out.printf("HP -> %d%n", potion.hpChange);
                this.setHitPoints(this.getHitPoints() + potion.hpChange);
            }
            this.inventory.remove(item);
        } else {
            System.out.printf("%s is not usable!", item);
        }
    }

    public void attack(Player playerOpponent) {
        if (playerOpponent.isAlive) {
            System.out.printf("%s starts an attack against %s...%n", playerName, playerOpponent.playerName);
        } else {
            System.out.printf("%s is dead!%n", playerOpponent.playerName);
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nHP: %d%nAlive: %b", playerName, this.getHitPoints(), isAlive);
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Player player = (Player) otherObj;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
