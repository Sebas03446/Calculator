package application.model;

import application.controller.CalculatorControllerInterface;

import java.util.List;
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    private String acc;
    Stack<Double> memory;
    private CalculatorControllerInterface controller;

    public String getAcc() {
        return acc;
    }

    public void setController(CalculatorControllerInterface controller) {
        this.controller = controller;
    }

    public void setAcc(String acc) {
        this.acc = this.acc + acc;
        controller.change(this.acc);
    }
    public CalculatorModel() {
        memory = new Stack<>();
        acc = "";
    }

    public void add(){
        Double a = pop();
        if (a == null){
            return;
        }

        Double b = pop();
        if (b == null){
            push(a);
            return;
        }

        push(a + b);
    }

    public void subtract(){}

    public void multiply(){}
    public void divide(){}

    public void push(){
        Double a = Double.parseDouble(this.acc);
        memory.push(a);
        restartAcc();

        controller.change(getMemory());
    }

    public void push(Double a){
        memory.push(a);
        controller.change(getMemory());
    }

    public void restartAcc(){
        this.acc = "";
        controller.change(this.acc);
    }

    public Double pop(){
        if(memory.isEmpty()){
            return null;
        }

        return memory.pop();
    }

    public void clear(){
        memory.clear();
    }

    public List<Double> getMemory(){
        return memory;
    }


}
