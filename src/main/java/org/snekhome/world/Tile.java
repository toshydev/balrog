package org.snekhome.world;

import java.awt.Color;

public enum Tile {
    WALL((char)178, Color.GRAY),
    GROUND((char)255, Color.DARK_GRAY),
    ENEMY((char)197, Color.RED),
    ENEMY_DEAD((char)170, Color.GRAY),
    BOSS((char)206, Color.RED),
    BOSS_DEAD((char)187, Color.GRAY),
    GOLD((char)155, Color.ORANGE),
    HEALTH((char)235, Color.RED),
    POISON((char)235, Color.GREEN),
    ARMOR((char)232, Color.BLUE),
    WEAPON((char)237, Color.BLUE);
    private final Color color;
    private final char glyph;

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public char getGlyph() {
        return glyph;
    }
}
