package org.snekhome.character;

public abstract class Npc extends Character {
    public Npc(String description) {
        super(description);
    }

    public Npc(String description, int hp) {
        super(description, hp);
    }
}
