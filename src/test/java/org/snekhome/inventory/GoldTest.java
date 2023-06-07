package org.snekhome.inventory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GoldTest {

    @ParameterizedTest
    @MethodSource("goldObjects")
    void testGoldConstructor(Gold actual, Gold expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> goldObjects() {
        return Stream.of(
                Arguments.of(new Gold(1), new Gold(1)),
                Arguments.of(new Gold(5), new Gold(5)),
                Arguments.of(new Gold(50), new Gold(50)),
                Arguments.of(new Gold(100), new Gold(100))
        );
    }

    @ParameterizedTest
    @MethodSource("goldCount")
    void testGoldCount(int actual, int expected) {
        assertEquals(expected, actual);
    }

    static Stream<Arguments> goldCount() {
        return Stream.of(
                Arguments.of(new Gold(1).count, new Gold(1).count),
                Arguments.of(new Gold(5).count, new Gold(5).count),
                Arguments.of(new Gold(50).count, new Gold(50).count),
                Arguments.of(new Gold(100).count, new Gold(100).count)
        );
    }

    @ParameterizedTest
    @MethodSource("goldVarious")
    void testGoldAddition(Gold actual, Gold toAdd, Gold expected) {
        actual.stack(toAdd);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> goldVarious() {
        return Stream.of(
                Arguments.of(new Gold(1), new Gold(2), new Gold(3)),
                Arguments.of(new Gold(5), new Gold(6), new Gold(11)),
                Arguments.of(new Gold(50), new Gold(25), new Gold(75)),
                Arguments.of(new Gold(100), new Gold(246), new Gold(346))
        );
    }
}