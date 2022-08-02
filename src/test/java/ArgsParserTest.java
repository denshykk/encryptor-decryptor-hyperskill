import org.junit.jupiter.api.Test;

import algorithms.Algorithm;
import algorithms.ShiftAlgorithm;
import algorithms.UnicodeAlgorithm;
import com.ginsberg.junit.exit.ExpectSystemExit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ArgsParserTest {

  private final Algorithm  shiftAlgorithm = new ShiftAlgorithm();
  private final ArgsParser argsParser     = new ArgsParser(shiftAlgorithm);

  @Test
  @ExpectSystemExit
  void shouldExitWithInvalidInputParseArgs() {
    String[] args = new String[] {"-error", "error"};

    argsParser.parseArgs(args);
  }

  @Test
  void shouldParseArgs() {
    String[] args = new String[] {"-mode", "enc", "-key", "1", "-data", "test", "-in", "test.txt", "-out", "test.txt"};

    argsParser.parseArgs(args);

    assertEquals("enc", argsParser.getMode());
    assertEquals(1, argsParser.getKey());
    assertEquals("test", argsParser.getData());
    assertEquals("test.txt", argsParser.getIn());
    assertEquals("test.txt", argsParser.getOut());
  }

  @Test
  @ExpectSystemExit
  void shouldNotParseKeyValue() {
    argsParser.parseKeyValue("`");
  }

  @Test
  void shouldParseKeyValue() {
    argsParser.parseKeyValue("1");

    assertEquals(1, argsParser.getKey());
  }

  @Test
  void shouldTakeDefaultAlgorithm() {
    argsParser.parseAlgorithm("");

    assertEquals(shiftAlgorithm, argsParser.getAlgorithm());
  }

  @Test
  void shouldTakeUnicodeAlgorithm() {
    argsParser.parseAlgorithm("unicode");

    assertInstanceOf(UnicodeAlgorithm.class, argsParser.getAlgorithm());
  }

}
