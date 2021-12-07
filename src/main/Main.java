package main;

public class Main {
    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser();
        parser.parseArgs(args);

        EncryptorDecryptor encryptorDecryptor = new EncryptorDecryptor(parser);
        encryptorDecryptor.invoke();
    }
}
