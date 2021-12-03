package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public record EncryptorDecryptor(ArgsParser parser) {

    public void invoke() {
        readFromFile();
        String result = switch (parser.getMode()) {
            case "enc" -> parser.getAlgorithm().encrypt(parser.getData(), parser.getKey());
            case "dec" -> parser.getAlgorithm().decrypt(parser.getData(), parser.getKey());
            default -> "";
        };

        writeToFile(result);
    }

    private void readFromFile() {
        if (parser.getData().isEmpty() && Objects.nonNull(parser.getIn())) {
            try {
                parser.setIn(new String(Files.readAllBytes(Paths.get(parser.getIn()))));
            } catch (IOException e) {
                System.err.println("Error reading from file");
                System.exit(1);
            }
        }
    }

    private void writeToFile(String result) {
        if (parser.getOut().isEmpty()) {
            System.out.println(result);
        } else {
            try {
                Files.write(Paths.get(parser.getOut()), result.getBytes());
            } catch (IOException e) {
                System.err.println("Error writing to the file");
                System.exit(1);
            }
        }
    }
}
