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
        if (this.acc.isEmpty()  && acc.equals(".")  ) {
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
        if(this.acc.isEmpty()){
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
        memory.clear();
        controller.change(memory);
    }
}
