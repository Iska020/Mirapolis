package ru.demo.mirapolis.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TestUtils {

    private static final SecureRandom random = new SecureRandom();

    public static String generateSomeString() {
        return new BigInteger(130, random).toString(32);
    }
}
