package org.lab4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.lab4.Lab4.BINARY_RADIX;

public class Task2 {

    private final static int DIGITS_IN_BINARY_NUMBER = 4; //количество позиций в двоичном коде (в данном случае четырехразрядный двоичный код)
    private final static String ALPHABET_LETTERS = "абвгдежзийклмноп";
    private final static String MESSAGE = "ппппппппийклмнопабвгдежзийклмноп";

    public void runTask() {
        //1. Присвоить буквам алфавита четырехразрядного двоичного кода
        //2. Заменить символы сообщения числами четырехразрядного двоичного кода
        //3. Разделить сообщение на блоки длиной 64 бита
        //4. Преобразовать двоичный код

        System.out.println("TASK TWO");
        //1. Присвоение буквам алфавита четырехразрядного двоичного кода
        List<String> binaryAlphabet = createBinaryAlphabet();
        //2. Замена символов сообщения числами четырехразрядного двоичного кода
        List<String> convertedMessage = convertStringToBinary(MESSAGE, binaryAlphabet);
        System.out.print("Message: " + MESSAGE + " = ");
        convertedMessage.forEach(System.out::print);
        System.out.println();
        //3. Разделение сообщения на блоки длиной 64 бита
        BigInteger message1 = convertToBigInt(convertedMessage.subList(0, convertedMessage.size() / 2));
        System.out.println("Message 1: " + message1);
        BigInteger message2 = convertToBigInt(convertedMessage.subList(convertedMessage.size() / 2, convertedMessage.size()));
        System.out.println("Message 2: " + message2);
        //4. Преобразование двоичного кода
        System.out.println("Message 1: " + new BigInteger(message1.toString(), BINARY_RADIX));
        System.out.println("Message 2: " + new BigInteger(message2.toString(), BINARY_RADIX));
        System.out.println();
    }

    public static List<String> createBinaryAlphabet() {
        List<String> alphabet = new ArrayList<>();
        for (int i = 0; i < ALPHABET_LETTERS.length(); i++) {
            alphabet.add(Integer.toBinaryString(i)); //перевод в двоичный код
        }
        return formatString(alphabet); //форматирование четырех разрядов
    }

    public static List<String> convertStringToBinary(String message, List<String> binaryAlphabet) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < message.length(); i++) {
            result.add(binaryAlphabet.get(ALPHABET_LETTERS.indexOf(message.charAt(i))));
        }
        return result;
    }

    public static List<String> formatString(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String position = list.get(i);
            int difference = DIGITS_IN_BINARY_NUMBER - position.length(); //сколько нулей отсутствует перед числом
            StringBuilder formatted = new StringBuilder();
            while (difference != 0) {
                formatted.append("0");
                difference--;
            }
            formatted.append(position);
            list.set(i, formatted.toString());
        }
        return list;
    }

    public static BigInteger convertToBigInt(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return new BigInteger(stringBuilder.toString());
    }
}
