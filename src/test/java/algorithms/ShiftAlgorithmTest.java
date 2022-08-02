package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShiftAlgorithmTest {

  private final Algorithm shiftAlgorithm = new ShiftAlgorithm();

  @Test
  void shouldEncryptMessage() {
    final String message = "test";

    final String encrypted = shiftAlgorithm.encrypt(message, 3);

    assertEquals("whvw", encrypted);
  }

  @Test
  void shouldDecryptMessage() {
    final String message = "whvw";

    final String decrypted = shiftAlgorithm.decrypt(message, 3);

    assertEquals("test", decrypted);
  }

}
