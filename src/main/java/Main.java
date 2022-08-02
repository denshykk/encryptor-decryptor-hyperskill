import algorithms.Algorithm;
import algorithms.ShiftAlgorithm;

public class Main {

  public static void main(String[] args) {
    Algorithm algorithm = new ShiftAlgorithm();

    ArgsParser parser = new ArgsParser(algorithm);
    parser.parseArgs(args);

    EncryptorDecryptor encryptorDecryptor = new EncryptorDecryptor(parser);
    encryptorDecryptor.invoke();
  }

}
