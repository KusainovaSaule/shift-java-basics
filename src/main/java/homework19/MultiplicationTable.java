package main.java.homework19;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int firstNum = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int secondNum = scanner.nextInt();
        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();

        if (step <= 0) {
            System.out.println("Ошибка: шаг должен быть положительным числом");
            return;
        }

        int[] numbers = generateNumbers(firstNum, secondNum, step);
        printMultiplicationTable(numbers);
        scanner.close();
    }

    public static int[] generateNumbers(int start, int end, int step) {
        int count = 0;

        for (int i = start; i <= end; i += step) {
            count++;
        }

        if ((end - start) % step != 0) {
            count++;
        }

        int[] numbers = new int[count];
        int index = 0;

        for (int i = start; i <= end; i += step) {
            numbers[index] = i;
            index++;
        }

        if (numbers[count - 1] != end) {
            numbers[count - 1] = end;
        }
        return numbers;
    }

    public static int getCellWidth(int number) {
        String data = String.valueOf(number);
        return data.length();
    }

    public static void printMultiplicationTable(int[] headers) {
        int n = headers.length;
        int maxWidth = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int product = headers[i] * headers[j];
                int width = getCellWidth(product);
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }
        }

        maxWidth = Math.max(maxWidth, 2);

        System.out.printf("%" + (maxWidth + 1) + "s", "");
        for (int j = 0; j < n; j++) {
            System.out.printf("%" + (maxWidth + 2) + "d", headers[j]);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%" + (maxWidth + 1) + "d", headers[i]);

            for (int j = 0; j < n; j++) {
                int product = headers[i] * headers[j];
                System.out.printf("%" + (maxWidth + 2) + "d", product);
            }
            System.out.println();
        }
    }
}