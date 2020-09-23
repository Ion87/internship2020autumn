package com.endava.internship.s2020.domain.utils;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class CommonUtils {

    public static String removeSpaces(final String row) {
        return row.replaceAll(" ", "");
    }
}