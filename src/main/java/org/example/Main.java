package org.example;

public class Main {

    // Дублювання коду
    public void printMessage() {
        System.out.println("Hello, World!");
    }

    public void displayMessage() {
        System.out.println("Hello, World!"); // Дублювання
    }

    public String getValue(String input) {
        if (input == null) {
            input.length(); // NullPointerException
        }
        return input;
    }

//    public String getValue(String input) {
//        if (input == null) {
//            return "Default Value";
//        }
//        return input;
//    }

    // Зайвий код
    public void unusedMethod() {
        if (false) {
            System.out.println("This will never execute");
        }
    }

    // Погана назва змінної та порушення стандартів кодування
    public void calculate(int a, int b) {
        int BADNAME = a + b;
        System.out.println("Result: " + BADNAME);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.printMessage();
        app.displayMessage();
        app.getValue(null);
        app.calculate(5, 10);
    }
}
