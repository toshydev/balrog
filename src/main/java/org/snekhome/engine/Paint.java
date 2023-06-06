package org.snekhome.engine;

import asciiPanel.AsciiPanel;
import org.snekhome.world.Screen;

import javax.swing.*;

public class Paint extends JFrame {
    public Screen screen;
    public AsciiPanel ap;

    public Paint() {
        super();
        AsciiPanel ap = new AsciiPanel();
        add(ap);
        pack();
        this.screen = new Screen();
        screen.displayWorld(ap);
        super.repaint();
    }

    public void repaint() {
        ap.clear();
        screen.displayWorld(ap);
        super.repaint();
    }

    public static void main(String[] args) {
        Paint game = new Paint();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }
}
