package main;

public class Main {
    public static void main(String[] args) {
        EncryptorDecryptor encryptorDecryptor = new EncryptorDecryptor();
        encryptorDecryptor.parseArgs(args);
        encryptorDecryptor.invoke();
    }
}