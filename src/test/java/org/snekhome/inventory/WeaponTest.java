package org.snekhome.inventory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    static Weapon sword = new Weapon("Sword", 15);
    static Weapon axe = new Weapon("Axe", 25);
    static Weapon staff = new Weapon("Staff", 10);
    static Weapon bow = new Weapon("Bow", 20);
    @ParameterizedTest
    @MethodSource("weapons")
    void testWeaponConstructor(Weapon actual, Weapon expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> weapons() {
        return Stream.of(
                Arguments.of(new Weapon("Sword", 15), sword),
                Arguments.of(new Weapon("Axe", 25), axe),
                Arguments.of(new Weapon("Staff", 10), staff),
                Arguments.of(new Weapon("Bow", 20), bow)
        );
    }

    @ParameterizedTest
    @MethodSource("weaponStats")
    void testWeaponStats(int actual, int expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> weaponStats() {
        return Stream.of(
                Arguments.of(new Weapon("Sword", 15).attackPoints, sword.attackPoints),
                Arguments.of(new Weapon("Axe", 25).attackPoints, axe.attackPoints),
                Arguments.of(new Weapon("Staff", 10).attackPoints, staff.attackPoints),
                Arguments.of(new Weapon("Bow", 20).attackPoints, bow.attackPoints)
        );
    }

    @ParameterizedTest
    @MethodSource("weaponDescription")
    void testWeaponDescription(String actual, String expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> weaponDescription() {
        return Stream.of(
                Arguments.of(new Weapon("Sword", 15).description, sword.description),
                Arguments.of(new Weapon("Axe", 25).description, axe.description),
                Arguments.of(new Weapon("Staff", 10).description, staff.description),
                Arguments.of(new Weapon("Bow", 20).description, bow.description)
        );
    }
}