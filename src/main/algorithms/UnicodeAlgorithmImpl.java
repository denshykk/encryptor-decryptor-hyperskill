package main.algorithms;

public class UnicodeAlgorithmImpl implements Algorithm {

    /**
     * <p><a href="#{@link}">{@link UnicodeAlgorithmImpl}</a> is an algorithm, that encrypts a
     * message * by shifting every letter through the Unicode table by a given offset (key).
     *
     * @param message data that are going to be encrypted
     * @param key     offset (key), by which letters will be shifted.
     * @return string value, encrypted text.
     */
    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            result.append((char) (c + key));
        }

        return result.toString();
    }

    /**
     * <p>
     * In order to decrypt the message it needs to be ciphered with a negative offset.
     * </p>
     *
     * @param message encrypted data that are going to be decrypted
     * @param key     offset, by which letters were shifted
     * @return string value, decrypted text
     */
    public String decrypt(String message, int key) {
        return encrypt(message, -key);
    }
}
