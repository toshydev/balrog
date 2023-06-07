package org.snekhome.inventory;

import org.snekhome.environment.Type;

public class Gold extends Item {
    public int count;

    public Gold(int count) {
        super("Gold", Type.GOLD);
        this.count += count;
        this.usable = false;
    }

    public void stack(Gold gold) {
        this.count += gold.count;
        gold = null;
    }

    public String toString() {
        return String.format("%d gold", count);
    }

    public static void main(String[] args) {

    }
}
