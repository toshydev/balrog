package org.snekhome.world;

import java.awt.Color;

public enum Tile {
    WALL((char)178, Color.GRAY),
    GROUND((char)255, Color.DARK_GRAY),
    EMEMY((char)197, Color.RED);
    private Color color;
    private char glyph;

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
