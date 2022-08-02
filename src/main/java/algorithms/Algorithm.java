package algorithms;

/**
 * <p>
 * <a href="#{@link}">{@link Algorithm}</a> is an interface, that defines the basic methods for
 * encryption and decryption.
 * </p>
 */
public interface Algorithm {

  /**
   * <p>Encrypts a message using a key.<p/>
   *
   * The function takes two parameters: <br/>
   * <p>
   * message: a String to be encrypted.<br/>
   * key:     an integer that specifies the shift value for the encryption.<br/><br/>
   * The function returns a String that is the input encrypted. <br/>
   * </p>
   * @param message The message to encrypt.
   * @param key The key to encrypt the message with.
   * @return A string.
   */
  String encrypt(String message, int key);

  /**
   * <p>Decrypts the message using the key.<p/>
   *
   * The function takes two parameters: <br/>
   * <p>
   * message: a String to be decrypted.<br/>
   * key:     an integer that specifies the shift value for the decryption.<br/><br/>
   * The function returns a decrypted message. <br/>
   * </p>
   *
   * @param message The message to be decrypted.
   * @param key The key to use for the decryption.
   * @return A string.
   */
  String decrypt(String message, int key);

}
