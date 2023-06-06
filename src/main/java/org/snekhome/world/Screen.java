package org.snekhome.world;

import asciiPanel.AsciiPanel;

import java.awt.*;

public class Screen {
    private int screenWidth = 79;
    private int screenHeight = 22;
    private World world;

    public Screen() {
        this.world = new World();
    }

    public void displayWorld(AsciiPanel ap) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                char glyphToWrite = world.plane[x][y].getGlyph();
                Color colorToWrite = world.plane[x][y].getColor();
                ap.write(glyphToWrite, x, y, colorToWrite);
            }
        }
    }
}
