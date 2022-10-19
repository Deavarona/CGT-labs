package org.lab3;

import java.io.*;
import java.util.Scanner;


public class Lab3 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String message = scan("Message");
        String gammaKey = scan("Gamma key");
        String encodeResult = encodeMessage(message, gammaKey);
        String decodeResult = encodeMessage(encodeResult, gammaKey);
        System.out.println("Encoded: " + encodeResult + "\nDecoded: " + decodeResult);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("filename.txt")))) {
            writer.write("Message: " + message+"\n");
            writer.write("Gamma key: " + gammaKey+"\n");
            writer.write("Encoded: " + encodeResult + "\n");
            writer.write("Decoded: " + decodeResult+"\n");
        }
    }

    public static String encodeMessage(String message, String key) {
        byte[] messageBytes = message.getBytes();
        byte[] keyBytes = key.getBytes();
        byte[] result = new byte[messageBytes.length];
        for (int i = 0, j = 0; i < messageBytes.length; i++, j++) {
            if (j == keyBytes.length) {
                j = 0;
            }
            result[i] = (byte) (messageBytes[i] ^ keyBytes[j]);
        }
        return new String(result);
    }

    public static String scan(String variableName) {
        System.out.print(variableName + ": ");
        return SCANNER.nextLine();
    }
}
