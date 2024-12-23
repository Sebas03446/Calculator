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
        if ((this.acc.isEmpty() && acc.equals(".")) || (acc.equals(".") && this.acc.contains(".")) ) {
            return;
        }
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

    public void opposite() {
        if (this.acc.startsWith("-")) {
            this.acc = this.acc.substring(1);
        } else {
            this.acc = "-" + this.acc;
        }

        controller.change(this.acc);
    }

    public void subtract(){
        Double a = pop();
        if (a == null){
            return;
        }

        Double b = pop();
        if (b == null){
            push(a);
            return;
        }

        push(a - b);
    }

    public void multiply(){
        Double a = pop();
        if (a == null){
            return;
        }

        Double b = pop();
        if (b == null){
            push(a);
            return;
        }

        push(a * b);
    }
    public void divide(){
        Double a = pop();
        if (a == null){
            return;
        }

        Double b = pop();
        if (b == null){
            push(a);
            return;
        }

        push(a / b);
    }

    public void push(){
        if(this.acc.isEmpty() || this.acc.equals(".") || this.acc.equals("-")){
            return;
        }

        Double a = Double.parseDouble(this.acc);
        memory.push(a);
        restartAcc();

        controller.change(memory);
    }

    public void push(Double a){
        memory.push(a);
        controller.change(memory);
    }

    public void restartAcc(){
        this.acc = "";
        controller.change(this.acc);
    }

    public Double pop(){
        if(memory.isEmpty()){
            return null;
        }
        Double value = memory.pop();
        controller.change(memory);
        return value;
    }

    public void clear(){
        this.memory.clear();
        controller.change(memory);
    }

    public void swap(){
        if(memory.isEmpty() || memory.size() < 2){
            return;
        }

        Double a = pop();
        Double b = pop();

        push(a);
        push(b);

        controller.change(memory);
    }
}
