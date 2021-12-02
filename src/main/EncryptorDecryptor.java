package main;

import main.algorithms.Algorithm;
import main.algorithms.ShiftAlgorithmImpl;
import main.algorithms.UnicodeAlgorithmImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptorDecryptor {
    private String mode;
    private String data;
    private int key;
    private String in;
    private String out;
    private Algorithm algorithm;

    public EncryptorDecryptor() {
        mode = "enc";
        data = "";
        key = 0;
        out = "";
    }


    public void invoke() {
        readFromFile();
        String result = switch (this.mode) {
            case "enc" -> algorithm.encrypt(data, key);
            case "dec" -> algorithm.decrypt(data, key);
            default -> "";
        };

        writeToFile(result);
    }


    private void readFromFile() {
        if (data.equals("") && in != null) {
            try {
                data = new String(Files.readAllBytes(Paths.get(in)));
            } catch (IOException e) {
                System.err.println("Error reading from file");
                System.exit(1);
            }
        }
    }

    private void writeToFile(String result) {
        if (out.equals("")) System.out.println(result);
        else {
            try {
                Files.write(Paths.get(out), result.getBytes());
            } catch (IOException e) {
                System.err.println("Error writing to the file");
                System.exit(1);
            }
        }
    }

    public void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    switch (args[i + 1]) {
                        case "shift" -> algorithm = new ShiftAlgorithmImpl();
                        case "unicode" -> algorithm = new UnicodeAlgorithmImpl();
                        default -> {
                            System.err.println("unknown algorithm " + args[i + 1]);
                            System.exit(1);
                        }
                    }
                    break;
                default:
                    System.err.println("Invalid argument");
                    System.exit(1);
            }
        }
    }
}