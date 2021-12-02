package main.algorithms;

public interface Algorithm {
    String encrypt(String message, int key);

    String decrypt(String message, int key);
}