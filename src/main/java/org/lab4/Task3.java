package org.lab4;

import java.math.BigInteger;

public class Task3 {
    private final int X_VALUE = 379317333;
    private final int SHIFT_AMOUNT = 5;

    public void runTask() {
        System.out.println("TASK THREE");
        System.out.println("X(10) = " + X_VALUE);
        BigInteger xBinary = new BigInteger(Integer.toBinaryString(X_VALUE));
        System.out.println("X(2) = " + xBinary);
        BigInteger xShiftedBinary = shiftLeft(xBinary);
        System.out.println("X(2) shifted = " + xShiftedBinary);
        int xShiftedDecimal = Integer.parseInt(xShiftedBinary.toString(), 2);
        System.out.println("X(10) shifted = " + xShiftedDecimal);
        System.out.println();
    }

    public BigInteger shiftLeft(BigInteger number) {
        char[] digits = number.toString().toCharArray();
        for (int i = 0; i < SHIFT_AMOUNT; i++) {
            char temp = digits[0];
            for (int j = 1; j < digits.length; j++) {
                digits[j - 1] = digits[j];
            }
            digits[digits.length - 1] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char digit : digits) {
            stringBuilder.append(digit);
        }
        return new BigInteger(stringBuilder.toString());
    }
}
