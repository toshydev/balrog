package org.snekhome.character;

import org.snekhome.environment.Factory;

import java.util.*;
import java.util.stream.Collectors;

public class EnemyFactory implements Factory {

    private final int width;
    private final int height;
    private int difficulty;
    private ArrayList<Enemy> enemies;

    public EnemyFactory() {
        this.width = 79;
        this.height = 22;
        this.difficulty = 3;
    }

    public EnemyFactory(int difficulty) {
        this.width = 79;
        this.height = 22;
        this.difficulty = difficulty;
    }

    public EnemyFactory(int width, int height) {
        this.width = width;
        this.height = height;
        this.difficulty = 3;
    }

    public EnemyFactory(int width, int height, int difficulty) {
        this(width, height);
        this.difficulty = difficulty;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public void generate() {
        this.enemies = new ArrayList<Enemy>();
        Set<Integer> xSet = new Random().ints(3, width - 3)
                .distinct()
                .limit(difficulty)
                .boxed()
                .collect(Collectors.toSet());
        Set<Integer> ySet = new Random().ints(3, height - 3)
                .distinct()
                .limit(difficulty)
                .boxed()
                .collect(Collectors.toSet());
        for (int i = 0; i < this.difficulty - 1; i++) {
            Enemy enemy = new Enemy(String.format("Enemy#%d", i + 1));
            enemy.posX = (int)xSet.toArray()[i];
            enemy.posY = (int)ySet.toArray()[i];
            addEnemy(enemy);
        }
        Enemy boss = new Enemy("Boss", 150);
        boss.posX = (int)xSet.toArray()[difficulty - 1];
        boss.posY = (int)ySet.toArray()[difficulty - 1];
        addEnemy(boss);
    }

    public void addEnemy(Enemy enemy) {
        if (enemy != null) {
            enemies.add(enemy);
        }
    }

    public static void main(String[] args) {
        EnemyFactory enemyFactory = new EnemyFactory(5);
        enemyFactory.generate();
        System.out.println(enemyFactory.getEnemies().toString());
    }
}
