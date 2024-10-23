package application.model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private String acc;
    Stack<Double> memory;

    public CalculatorModel() {
        memory = new Stack<>();
        acc = "";
    }

    public void add(double a, double b){
        Double result = a + b;
        memory.push(result);
    }

    public void subtract(double a, double b){
        Double result = a - b;
        memory.push(result);
    }

    public void multiply(double a, double b){
        Double result = a * b;
        memory.push(result);
    }

    public void divide(double a, double b){
        Double result = a / b;
        memory.push(result);
    }

    public void push(double a){
        System.out.println("push");
        memory.push(a);
    }

    public void pop(){
        if(memory.isEmpty()){
            return;
        }

        memory.pop();
    }

    public void clear(){
        memory.clear();
    }


}
