package task2;

import java.util.Scanner;
import java.util.Arrays;

public class Worker implements Comparable<Worker> {

    private String fullName;
    private String jobTitle;
    private int startYear;

    public Worker(String fullName, String jobTitle, int startYear) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.startYear = startYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public int compareTo(Worker other) {
        return fullName.compareTo(other.fullName);
    }

    public String toString() {
        return " Працівник: " + fullName + " Посада: " + jobTitle +
                " Рік початку роботи: " + startYear;
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Worker[] workers = new Worker[5];
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Введіть дані про працівника " + (i + 1));
                System.out.print("Прізвище та ініціали: ");
                String fullName = scanner.nextLine();

                System.out.print("Назва посади: ");
                String jobTitle = scanner.nextLine();

                System.out.print("Рік надходження на роботу: ");
                int startYear = Integer.parseInt(scanner.nextLine());

                if (startYear < 1900 || startYear > 2023) {
                    throw new NumberFormatException("Рік надходження на роботу має бути від 1900 до 2023");
                }

                workers[i] = new Worker(fullName, jobTitle, startYear);
            } catch (NumberFormatException e) {
                System.err.println("Помилка: " + e.getMessage());
                i--;  // Повторити введення для цього працівника
            }
        }

        Arrays.sort(workers);

        System.out.print("Введіть рік для пошуку працівників зі стажем більше: ");
        int searchYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Список працівників зі стажем більше " + searchYear + " років:");

        for (Worker worker : workers) {
            if (2023 - worker.getStartYear() > searchYear) {
                System.out.println(worker);
            }
        }
    }
}