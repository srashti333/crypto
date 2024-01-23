import java.util.Scanner;
import java.io.*;

public class Main {

    public static char ch;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Press the desired char according to the operation needed\n 1> press 'E' for encryption \n 2> press 'D' for decryption\n 3> press 'B' for brute force.\n 4> press 'C' for exit.");
        boolean flag=true;
        while(flag){
            ch=sc.next().charAt(0);
            if(ch=='E'|| ch=='D' || ch=='B' || ch=='C'){
                switch (ch){
                    case 'E': System.out.println(encrp());
                            break;
                    case 'D': System.out.println(decrp());
                            break;
                    case 'B': System.out.println(brute());
                            break;
                    case 'C': return;
                            
                    default: System.out.println("invalid input");
                }
                flag=false;
            }else{
                System.out.println("the input is invalid please enter again");
            }
        }
    }
    public static String encrp() {
        Console cc=System.console();

        System.out.print("Enter the plaintext: ");
        String plaintext = cc.readLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        String ciphertext = "";
        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char encryptedChar = (char) (((Character.toLowerCase(ch) - 'a' + key) % 26 + 26)%26 + 'a');
                ciphertext+=encryptedChar;
            } else {
                ciphertext+=ch;
            }
        }

        return ciphertext.toString().toUpperCase();

    }
        
    public static String decrp() {
        Console cc=System.console();

        System.out.print("Enter the ciphertext: ");
        String ciphertext = cc.readLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        String plaintext = "";
        for (char ch : ciphertext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char decryptedChar = (char) (((Character.toLowerCase(ch) - 'a' - key) % 26 + 26)%26 + 'a');
                plaintext+=decryptedChar;
            } else {
                plaintext+=ch;
            }
        }

        return plaintext.toString().toUpperCase();

    }
    public static int brute() {
        Console cc=System.console();

        System.out.print("Enter the ciphertext: ");
        String ciphertext = cc.readLine();


        System.out.print("Enter the plaintext: ");
        String plaintext = cc.readLine();
        int key=0;
        for (int i=0;i<26;i++) {
            if ((ciphertext.charAt(0)-i)==plaintext.charAt(0)) {
                key=i;
            }
        }

        return key;

    }
        
        
}
