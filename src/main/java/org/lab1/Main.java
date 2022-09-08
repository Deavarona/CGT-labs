package org.lab1;

import java.util.*;

public class Main {

    private static final String CIPHER_1 = "Srobdoskdehwlf vxevwlwxwlrq flskhuv";
    private static final String CIPHER_2 = "KjgyVgkcVWZqdX nsWnqdqsqdji XdkcZmn";
    private static final ArrayList<Character> ALPHABET = createAlphabet();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Шифр 1
        ArrayList<Character> msg1 = convertToArrayList(CIPHER_1);
        printArray("Original message: ", msg1);
        System.out.println("Key: "+searchCesarCipherKey(msg1));
        System.out.println();

        //Шифр 2
        ArrayList<Character> msg2 = convertToArrayList(CIPHER_2.toLowerCase());
        printArray("Original message: ", msg2);
        ArrayList<Character> cipherKey = searchOneToOneSubstitutionKey(msg2);
        System.out.println();

        //Вывод алфавита и ключа
        printArray("Key alphabet: ", cipherKey);
        printArray("Result message: ", decryptOneToOneSubstitution(cipherKey, msg2));
        switchCipherKeyLetters(cipherKey, msg2);


        scanner.close();
    }

    public static void switchCipherKeyLetters(ArrayList<Character> cipherAlphabet, ArrayList<Character> message){
        boolean isExit=false;
        while(!isExit){
            System.out.print("First letter: ");
            char letter1 = scanner.next().charAt(0);
            System.out.print("Second letter: ");
            char letter2 = scanner.next().charAt(0);
            Collections.swap(cipherAlphabet, ALPHABET.indexOf(letter1), ALPHABET.indexOf(letter2));
            printArray("Result alphabet: ", cipherAlphabet);
            printArray("Result message: ", decryptOneToOneSubstitution(cipherAlphabet, message));
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }
    }

    public static ArrayList<Character> searchOneToOneSubstitutionKey(ArrayList<Character> message){
        ArrayList<Character> cipherAlphabet = createAlphabet();
        boolean isExit = false;
        while(!isExit) {
            shiftToRightByAlphabet(cipherAlphabet);
            printArray("Decrypted message: ", decryptOneToOneSubstitution(cipherAlphabet, message));
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }
        return cipherAlphabet;
    }

    public static ArrayList<Character> decryptOneToOneSubstitution(ArrayList<Character> cipherAlphabet, ArrayList<Character> message){
        ArrayList<Character> decryptedMessage = new ArrayList<>(message);
        for(int i=0; i<message.size(); i++){
            if(message.get(i) != ' '){
                decryptedMessage.set(i, ALPHABET.get(cipherAlphabet.indexOf(message.get(i))));
            }
        }
        return decryptedMessage;
    }

    public static int searchCesarCipherKey(ArrayList<Character> message){
        int key = 0;
        boolean isExit = false;
        while(!isExit) {
            shiftToRightByAlphabet(message);
            key++;
            printArray("Message: ", message);
            System.out.print("Press 0 to exit. Input: ");
            if(scanner.next().equals("0")){
                isExit=true;
            }
        }
        return key;
    }

    public static ArrayList<Character> createAlphabet(){
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char ch = 'a'; ch <='z'; ch++){
            alphabet.add(ch);
        }
        return alphabet;
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