package main.algorithms;

public class ShiftAlgorithmImpl implements Algorithm {

    /**
     * <p>
     * <a href="#{@link}">{@link ShiftAlgorithmImpl}</a> is an algorithm, that encrypts a message
     * by shifting every letter through the alphabet by a given offset (key).
     *
     * If the transformation goes beyond the uppercase or lowercase letter Z, we go back to
     * the start of the alphabet. It's accomplished by performing a modulo 26 operation on it.
     * </p>
     *
     * @param message data that are going to be encrypted
     * @param key offset (key), by which letters will be shifted.
     * @return string value, encrypted text
     */
    public String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = Character.isUpperCase(c) ? 65 : 97;
                result.append((char) ((c + key - shift) % 26 + shift));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    /**
     * <p>
     * In order to decrypt the message it needs to be ciphered with a negative offset.
     * </p>
     *
     * @param message encrypted data that are going to be decrypted
     * @param key offset, by which letters were shifted
     * @return string value, decrypted text
     */
    public String decrypt(String message, int key) {
        return encrypt(message, 26 - (key % 26));
    }
}