import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import algorithms.ShiftAlgorithm;
import com.ginsberg.junit.exit.ExpectSystemExit;
import lombok.SneakyThrows;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EncryptorDecryptorTest {

  private static final String PATH        = "src/test/resources/test.txt";
  private static final String OUTPUT_PATH = "src/test/resources/test-output.txt";
  private static final String TEST        = "test";

  @Mock
  private ArgsParser         argsParser;
  @InjectMocks
  private EncryptorDecryptor encryptorDecryptor;

  @BeforeAll
  @SneakyThrows
  static void beforeAll() {
    File file = new File(PATH);
    Files.writeString(file.toPath(), TEST);
  }

  @AfterAll
  static void afterAll() {
    File file = new File(PATH);
    File file2 = new File(OUTPUT_PATH);
    file.delete();
    file2.delete();
  }

  @Test
  @SneakyThrows
  void shouldTestInvokeMethod() {
    when(argsParser.getData()).thenReturn("");
    when(argsParser.getMode()).thenReturn("enc");
    when(argsParser.getAlgorithm()).thenReturn(new ShiftAlgorithm());
    when(argsParser.getKey()).thenReturn(1);
    when(argsParser.getOut()).thenReturn(OUTPUT_PATH);
    when(argsParser.getData()).thenReturn(TEST);

    encryptorDecryptor.invoke();

    assertEquals(TEST, argsParser.getData());
    assertEquals("uftu", Files.readString(Path.of(OUTPUT_PATH)));
  }

  @Test
  void shouldReadFromFile() {
    when(argsParser.getData()).thenReturn("");
    when(argsParser.getIn()).thenReturn(PATH);

    encryptorDecryptor.readFromFile();

    verify(argsParser).setData(TEST);
  }

  @Test
  @ExpectSystemExit
  void shouldNotReadFromFileAndExit() {
    when(argsParser.getData()).thenReturn("");
    when(argsParser.getIn()).thenReturn("file not found");

    encryptorDecryptor.readFromFile();
  }


  @Test
  void shouldWriteToConsole() {
    when(argsParser.getOut()).thenReturn("");

    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    encryptorDecryptor.writeToFile(TEST);

    assertEquals(TEST + System.lineSeparator(), out.toString());
  }

}
