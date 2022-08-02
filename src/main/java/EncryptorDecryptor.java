import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

/**
 * > EncryptorDecryptor is the class that is used to encrypt and decrypt strings.
 */
@RequiredArgsConstructor
public class EncryptorDecryptor {

  private final ArgsParser parser;

  /**
   * Read from file, encrypt/decrypt, write to file.
   */
  public void invoke() {
    readFromFile();

    String result = switch (parser.getMode()) {
      case "enc" -> parser.getAlgorithm().encrypt(parser.getData(), parser.getKey());
      case "dec" -> parser.getAlgorithm().decrypt(parser.getData(), parser.getKey());
      default -> "";
    };

    writeToFile(result);
  }

  /**
   * If the parser's data is empty and the parser's input file is not null, then read the data from the file and set the
   * parser's data to the file's contents
   */
  public void readFromFile() {
    if (parser.getData().isEmpty() && Objects.nonNull(parser.getIn())) {
      try {
        parser.setData(new String(Files.readAllBytes(Paths.get(parser.getIn()))));
      } catch (IOException e) {
        System.err.println("Error reading from file");
        System.exit(1);
      }
    }
  }

  /**
   * If the output file is empty, print the result to the console, otherwise write the result to the output file
   *
   * @param result
   *     the result of the operation
   */
  public void writeToFile(String result) {
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
