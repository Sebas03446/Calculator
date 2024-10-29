package application.model;

import application.controller.CalculatorControllerInterface;

public interface CalculatorModelInterface {
    public void add( double x, double y );
    public void subtract( double x, double y );
    public void multiply( double x, double y );
    public void divide( double x, double y );
    //public void opposite( double x);
    public void push(double value);
    public void pop();
    public void clear();
    public void  setAcc(String acc);
    public String getAcc();
    public void setController(CalculatorControllerInterface controller);
}
