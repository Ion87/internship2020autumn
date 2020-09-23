package com.endava.internship.s2020.domain.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CommonUtilsTest {
    @ParameterizedTest
    @MethodSource("provideArgsForRemoveSpaces")
    void shouldReturnRowWithoutSpaces(final String row, final String expectedResult) {
        assertThat(CommonUtils.removeSpaces(row)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> provideArgsForRemoveSpaces() {
        return Stream.of(
                Arguments.of("aaa aaa", "aaaaaa"),
                Arguments.of("aaa B c D e", "aaaBcDe"),
                Arguments.of("a               b", "ab"),
                Arguments.of("a\tb", "a\tb")
        );
    }
}