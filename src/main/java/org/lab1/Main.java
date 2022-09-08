package org.lab1;

import java.util.*;

public class Main {

    private static final String CIPHER_1 = "Srobdoskdehwlf vxevwlwxwlrq flskhuv";
    private static final String CIPHER_2 = "KjgyVgkcVWZqdX nsWnqdqsqdji XdkcZmn";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Создание алфавита
        ArrayList<Character> alphabet = new ArrayList<>();
        createAlphabet(alphabet);

        //Создание алфавита-ключа для шифра
        ArrayList<Character> cipherAlphabet = new ArrayList<>();
        createAlphabet(cipherAlphabet);

        //Шифр 1
        ArrayList<Character> msg1 = convertToArrayList(CIPHER_1);
        printArray("Original message: ", msg1);
        cesarDecryption(cipherAlphabet, msg1);
        System.out.println();

        //Вывод алфавита и ключа
        printArray("Original alphabet: ", alphabet);
        printArray("Final alphabet: ", cipherAlphabet);
        System.out.println();

        //Шифр 2
        ArrayList<Character> msg2 = convertToArrayList(CIPHER_2.toLowerCase());
        printArray("Original message: ", msg2);



        ArrayList<Character> omgzaebalo = convertToArrayList(CIPHER_2.toLowerCase());
        oneToOneSubstitutionCipher(cipherAlphabet, alphabet, msg2);
        System.out.println();

        //Вывод ключа и сообщения
        printArray("Result alphabet: ", cipherAlphabet);
        printArray("Result message: ", msg2);

        boolean isExit=false;
        while(!isExit){
            System.out.print("First letter: ");
            char letter1 = scanner.next().charAt(0);
            System.out.print("Second letter: ");
            char letter2 = scanner.next().charAt(0);
            Collections.swap(cipherAlphabet, cipherAlphabet.indexOf(letter1), cipherAlphabet.indexOf(letter2));
            printArray("Result alphabet: ", cipherAlphabet);

            for(int i=0; i<msg2.size(); i++){
                if(msg2.get(i) != ' ')
                    msg2.set(i, alphabet.get(cipherAlphabet.indexOf(omgzaebalo.get(i))));
            }

            printArray("Result message: ", msg2);
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }

        scanner.close();
    }

    public static void oneToOneSubstitutionCipher(ArrayList<Character> cipherAlphabet, ArrayList<Character> alphabet, ArrayList<Character> message){
        ArrayList<Character> decryptedMessage = new ArrayList<>(message);
        boolean isExit = false;
        while(!isExit) {
            shiftToRightByAlphabet(cipherAlphabet);
            for(int i=0; i<message.size(); i++){
                if(message.get(i) != ' '){
                    decryptedMessage.set(i, alphabet.get(cipherAlphabet.indexOf(message.get(i))));
                }
            }
            printArray("Decrypted message: ", decryptedMessage);
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }
        message.removeAll(message);
        message.addAll(decryptedMessage);
    }

    public static void cesarDecryption(ArrayList<Character> alphabet, ArrayList<Character> message){
        int key = 0;
        boolean isExit = false;
        while(!isExit) {
            shiftToRightByAlphabet(message);
            shiftToRightByAlphabet(alphabet);
            key++;
            printArray("Message: ", message);
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }
        System.out.println("Key: "+ key);
    }

    public static void createAlphabet(ArrayList<Character> alphabet){
        for (char ch = 'a'; ch <='z'; ch++){
            alphabet.add(ch);
        }
    }

    public static void printArray(String text, ArrayList<Character> array){
        System.out.print(text);
        for(char ch : array){
            System.out.print(ch+" ");
        }
        System.out.println();
    }

    public static void shiftToRightByAlphabet(ArrayList<Character> array){
        char temp;
        for(int i=0; i<array.size(); i++){
            temp=array.get(i);
            if(temp == 'a' || temp == 'A'){
                if(temp == 'a') temp = 'z';
                else temp = 'Z';
            } else if(temp != ' '){
                temp--;
            }
            array.set(i, temp);
        }
    }

    public static ArrayList<Character> convertToArrayList(String message){
        ArrayList<Character> msg = new ArrayList<>();
        for (Character letter : message.toCharArray()){
            msg.add(letter);
        }
        return msg;
    }
}