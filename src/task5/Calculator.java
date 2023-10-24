package task5;

import java.util.Scanner;

public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Помилка: ділення на нуль недопустиме.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть 1 число: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Введіть 2 число: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Оберіть операцію: +, -, *, / ");
            char operator = scanner.nextLine().charAt(0);

            double result;

            switch (operator){
                case '+' :
                    result = add(num1, num2);
                    break;
                case '-':
                    result = sub(num1, num2);
                    break;
                case '*':
                    result = mul(num1, num2);
                    break;
                case '/':
                    result = div(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Помилка: невідома операція.");
            }
            System.out.println("Результат операції: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Помилка: введені некоректні числа.");
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}