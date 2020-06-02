package Bai3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws ScriptException {

        Stack<String> stack = new Stack<>();

//        String[] array = {"2", "3", "4", "+","*","5","-","2","2","*","+"};

        stack.push("+");
        stack.push("*");
        stack.push("2");
        stack.push("2");
        stack.push("-");
        stack.push("5");
        stack.push("*");
        stack.push("+");
        stack.push("4");
        stack.push("3");
        stack.push("2");
        
        System.out.println(stack);

        String result = (convertToInfix(stack));

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        System.out.println(engine.eval(result));
    }

    public static boolean isOperator(String character) {
        switch (character) {
            case "+":
            case "-":
            case "*":
                return false;
            default:
                return true;
        }
    }

    public static String convertToInfix(Stack<String> stack) {

        Stack<String> stack2 = new Stack<>();

        int StackSize = stack.size();

        for (int i = 0; i < StackSize; i++) {
            String character = stack.pop();
            if (isOperator(character)) {
                stack2.push(character + "");
            } else {
                String firstOperand = stack2.peek();
                stack2.pop();

                String secondOperand = stack2.peek();
                stack2.pop();

                stack2.push("(" + secondOperand + character + firstOperand + ")");
            }
        }
        return stack2.peek();
    }
}
