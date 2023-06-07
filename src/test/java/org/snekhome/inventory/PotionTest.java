package org.snekhome.inventory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    static Potion healthLesser = new Potion("Lesser Health Potion", 25);
    static Potion healthNormal = new Potion("Normal Health Potion", 50);
    static Potion healthGreat = new Potion("Great Health Potion", 75);
    static Potion poisonWeak = new Potion("Weak Poison", -15);
    static Potion poisonStrong = new Potion("Strong Poison", -25);

    @ParameterizedTest
    @MethodSource("potions")
    void testPotionConstructor(Potion actual, Potion expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> potions() {
        return Stream.of(
                Arguments.of(new Potion("Lesser Health Potion", 25), healthLesser),
                Arguments.of(new Potion("Normal Health Potion", 50), healthNormal),
                Arguments.of(new Potion("Great Health Potion", 75), healthGreat),
                Arguments.of(new Potion("Weak Poison", -15), poisonWeak),
                Arguments.of(new Potion("Strong Poison", -25), poisonStrong)
        );
    }

    @ParameterizedTest
    @MethodSource("potionStats")
    void testPotionStats(int actual, int expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> potionStats() {
        return Stream.of(
                Arguments.of(new Potion("Lesser Health Potion", 25).hpChange, healthLesser.hpChange),
                Arguments.of(new Potion("Normal Health Potion", 50).hpChange, healthNormal.hpChange),
                Arguments.of(new Potion("Great Health Potion", 75).hpChange, healthGreat.hpChange),
                Arguments.of(new Potion("Weak Poison", -15).hpChange, poisonWeak.hpChange),
                Arguments.of(new Potion("Strong Poison", -25).hpChange, poisonStrong.hpChange)
        );
    }

    @ParameterizedTest
    @MethodSource("potionDescription")
    void testPotionDescription(String actual, String expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> potionDescription() {
        return Stream.of(
                Arguments.of(new Potion("Lesser Health Potion", 25).description, healthLesser.description),
                Arguments.of(new Potion("Normal Health Potion", 50).description, healthNormal.description),
                Arguments.of(new Potion("Great Health Potion", 75).description, healthGreat.description),
                Arguments.of(new Potion("Weak Poison", -15).description, poisonWeak.description),
                Arguments.of(new Potion("Strong Poison", -25).description, poisonStrong.description)
        );
    }
}