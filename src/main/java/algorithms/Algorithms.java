package algorithms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * <a href="#{@link}">{@link Algorithm}</a> is an interface, that defines the basic methods for
 * encryption and decryption.
 * </p>
 */
@RequiredArgsConstructor
public enum Algorithms {

  UNICODE("unicode"), SHIFT("shift");

  @Getter
  private final String label;

}
