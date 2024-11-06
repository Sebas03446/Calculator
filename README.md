# Calculator RPN

## Project Description

This project is a calculator using Reverse Polish Notation (RPN). The project follows the Model-View-Controller (MVC) design pattern and is built with Java and JavaFX.

### Simplified Specifications of the Calculator

- The calculator performs basic arithmetic operations (addition, subtraction, multiplication, division).
- The calculator operates in Reverse Polish Notation (RPN): operands are pushed onto a stack, and operators are applied to the operands on the stack. For example, to add two numbers:
  - Enter the first number and push it onto the stack (push button).
  - Enter the second number and push it onto the stack (push button).
  - Apply the addition operation (plus button).
  This logic is convenient for handling complex expressions (e.g., 3*(2+5*(4+7))) without using parentheses.

## Instructions for Running the Project

1. Clone the repository:
   ```
   git clone https://github.com/Sebas03446/Calculator.git
   ```
2. Navigate to the project directory:
   ```
   cd Calculator
   ```
3. Download JavaFX
4. Execute jar file
    ```
    java --module-path path/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -jar ./Calculator.jar 
    ```
   `
