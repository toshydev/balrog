package org.snekhome.environment;

public interface Movement {
    void move(Direction direction);

    boolean checkCollision(Object object);
}
