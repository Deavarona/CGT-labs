package org.lab4;

import java.math.BigInteger;

import static org.lab4.Lab4.BINARY_RADIX;

public class Task1 {
    public void runTask() {
        System.out.println("TASK ONE");
        BigInteger number = BigInteger.valueOf(3); //число
        int numberExponent = 43; //в какую степень возводится число
        BigInteger result = number.pow(numberExponent);
        System.out.println("3^43 = " + result);
        System.out.println("3^43 binary = " + result.toString(BINARY_RADIX));
        System.out.println();
    }
}
