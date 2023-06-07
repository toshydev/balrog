package org.snekhome.inventory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    static Armor plate = new Armor("Breastplate", 20);
    static Armor gauntlets = new Armor("Gauntlets", 5);
    static Armor cuirass = new Armor("Leather Cuirass", 15);
    static Armor robe = new Armor("Robe", 12);
    @ParameterizedTest
    @MethodSource("armors")
    void testWeaponConstructor(Armor actual, Armor expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> armors() {
        return Stream.of(
                Arguments.of(new Armor("Breastplate", 20), plate),
                Arguments.of(new Armor("Gauntlets", 5), gauntlets),
                Arguments.of(new Armor("Leather Cuirass", 15), cuirass),
                Arguments.of(new Armor("Robe", 12), robe)
        );
    }

    @ParameterizedTest
    @MethodSource("armorStats")
    void testWeaponStats(int actual, int expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> armorStats() {
        return Stream.of(
                Arguments.of(new Armor("Breastplate", 20).armorPoints, plate.armorPoints),
                Arguments.of(new Armor("Gauntlets", 5).armorPoints, gauntlets.armorPoints),
                Arguments.of(new Armor("Leather Cuirass", 15).armorPoints, cuirass.armorPoints),
                Arguments.of(new Armor("Robe", 12).armorPoints, robe.armorPoints)
        );
    }

    @ParameterizedTest
    @MethodSource("armorDescription")
    void testWeaponDescription(String actual, String expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> armorDescription() {
        return Stream.of(
                Arguments.of(new Armor("Breastplate", 20).description, plate.description),
                Arguments.of(new Armor("Gauntlets", 5).description, gauntlets.description),
                Arguments.of(new Armor("Leather Cuirass", 15).description, cuirass.description),
                Arguments.of(new Armor("Robe", 12).description, robe.description)
        );
    }
}