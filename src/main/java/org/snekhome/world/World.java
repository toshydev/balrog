package org.snekhome.world;

import org.snekhome.character.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    public Tile[][] plane;
    public int width = 79;
    public int height = 22;
    public List<Enemy> enemies;
    public World() {
        createPlane();
        this.enemies = new ArrayList<>();
        generateEnemies();
        populatePlane();
    }

    public void createPlane() {
        Tile[][] newPlane = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (y < 1 || y > height - 2) {
                    newPlane[x][y] = Tile.WALL;
                }
                else if ((x < 1 || x > width - 2)) {
                    newPlane[x][y] = Tile.WALL;
                } else {
                    newPlane[x][y] = Tile.GROUND;
                }
            }
        }
        this.plane = newPlane;
    }

    public void generateEnemies() {
        for (int i = 0; i < 5; i++) {
            Enemy enemy = new Enemy(String.format("Monster#%d", i));
            Random random = new Random();
            enemy.posX = random.nextInt(3, width - 3);
            enemy.posY = random.nextInt(3, height - 3);
            addEnemy(enemy);
        }
    }

    public void addEnemy(Enemy enemy) {
        if (enemy != null) {
            enemies.add(enemy);
        }
    }

    public void populatePlane() {
        for (Enemy enemy : enemies) {
            if ((enemy.posX > 2 && enemy.posX < width - 2) && (enemy.posY > 2 && enemy.posY < height - 2)) {
                if (enemy.isAlive) {
                    this.plane[enemy.posX][enemy.posY] = Tile.EMEMY;
                } else {
                    this.plane[enemy.posX][enemy.posY] = Tile.ENEMY_DEAD;
                }
            }
        }
    }
}
