package main;

import main.algorithms.Algorithm;
import main.algorithms.Algorithms;
import main.algorithms.ShiftAlgorithmImpl;
import main.algorithms.UnicodeAlgorithmImpl;

public class ArgsParser {

    private String mode;
    private String data;
    private int key;
    private String in;
    private String out;
    private Algorithm algorithm;

    public ArgsParser() {
        mode = "enc";
        data = "";
        key = 0;
        out = "";
        algorithm = new ShiftAlgorithmImpl();
    }

    public void parseArgs(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode" -> mode = args[i + 1];
                case "-key" -> parseKeyValue(args[i + 1]);
                case "-data" -> data = args[i + 1];
                case "-in" -> in = args[i + 1];
                case "-out" -> out = args[i + 1];
                case "-alg" -> parseAlgorithm(args[i + 1]);
                default -> {
                    System.err.println("Invalid argument");
                    System.exit(1);
                }
            }
        }
    }

    public void parseKeyValue(String keyArgument) {
        try {
            key = Integer.parseInt(keyArgument);
        } catch (NumberFormatException e) {
            System.err.println("Wrong offset (key) format");
            System.exit(1);
        }
    }

    public void parseAlgorithm(String algorithmArgument) {
        if (algorithmArgument.equals(Algorithms.UNICODE.getLabel())) {
            algorithm = new UnicodeAlgorithmImpl();
        }
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setData(String data) {
        this.data = data;
    }
}
