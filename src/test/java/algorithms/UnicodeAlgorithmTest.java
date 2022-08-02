package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnicodeAlgorithmTest {

  private final Algorithm unicodeAlgorithm = new UnicodeAlgorithm();

  @Test
  void shouldEncryptMessage() {
    final String message = "test";

    final String encrypted = unicodeAlgorithm.encrypt(message, 3);

    assertEquals("whvw", encrypted);
  }

  @Test
  void shouldDecryptMessage() {
    final String message = "test";

    final String decrypted = unicodeAlgorithm.decrypt(message, 3);

    assertEquals("qbpq", decrypted);
  }

}
