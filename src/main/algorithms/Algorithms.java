package main.algorithms;

public enum Algorithms {

    UNICODE("unicode"), SHIFT("shift");

    private final String label;

    Algorithms(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
