import algorithms.Algorithm;
import algorithms.Algorithms;
import algorithms.UnicodeAlgorithm;
import lombok.Getter;
import lombok.Setter;

/**
 * Simple command line argument parser
 */
@Getter
public class ArgsParser {

  private String    mode;
  @Setter
  private String    data;
  private int       key;
  private String    in;
  private String    out;
  private Algorithm algorithm;

  public ArgsParser(final Algorithm algorithm) {
    mode = "enc";
    data = "";
    key = 0;
    out = "";
    this.algorithm = algorithm;
  }

  /**
   * Parses command line arguments
   *
   * @param args
   *     command line arguments
   */
  public void parseArgs(String[] args) {
    for (int i = 0; i < args.length; i += 2) {
      switch (args[i]) {
        case "-mode" -> mode = args[i + 1];
        case "-key" -> parseKeyValue(args[i + 1]);
        case "-data" -> data = args[i + 1];
        case "-in" -> in = args[i + 1];
        case "-out" -> out = args[i + 1];
        case "-alg" -> parseAlgorithm(args[i + 1]);
        default -> {
          System.err.println("Invalid argument");
          System.exit(1);
        }
      }
    }
  }

  /**
   * It takes a string, tries to parse it as an integer, and if it fails, it prints an error message and exits the
   * program
   *
   * @param keyArgument
   *     The argument passed to the program.
   */
  public void parseKeyValue(String keyArgument) {
    try {
      key = Integer.parseInt(keyArgument);
    } catch (NumberFormatException e) {
      System.err.println("Wrong offset (key) format");
      System.exit(1);
    }
  }

  /**
   * If the algorithm argument is equal to the label of the Unicode algorithm, then set the algorithm to a new instance
   * of the Unicode algorithm implementation. Else leaves Shift algorithm as is.
   *
   * @param algorithmArgument
   *     The argument passed to the program.
   */
  public void parseAlgorithm(String algorithmArgument) {
    if (algorithmArgument.equals(Algorithms.UNICODE.getLabel())) {
      algorithm = new UnicodeAlgorithm();
    }
  }

}
