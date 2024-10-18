package application.model;

import java.util.Stack;

public class CalculatorModel {
    private String acc;
    Stack<Double> memory;

    public CalculatorModel() {
        memory = new Stack<>();
        acc = "";
    }


}
