package main.java.homework202;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MultiplicationTableToFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            int firstNum = scanner.nextInt();
            System.out.print("Введите второе число: ");
            int secondNum = scanner.nextInt();
            System.out.print("Введите шаг: ");
            int step = scanner.nextInt();

            if (step <= 0) {
                System.out.println("Ошибка: шаг должен быть положительным числом");
                scanner.close();
                return;
            }

            System.out.print("Введите имя файла для сохранения: ");
            String fileName = scanner.next();

            int[] numbers = generateNumbers(firstNum, secondNum, step);

            saveTableToFile(numbers, fileName);
            System.out.println("Таблица умножения сохранена в файл: " + fileName);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Ошибка: введите целое число!");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        } finally {
            scanner.close();
        }
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
        return String.valueOf(number).length();
    }

    public static void saveTableToFile(int[] headers, String fileName) throws IOException {
        FileOutputStream fileOutputStream = null;
        PrintWriter printWriter = null;

        try {
            fileOutputStream = new FileOutputStream(fileName);
            printWriter = new PrintWriter(fileOutputStream);

            int n = headers.length;

            int maxWidth = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int product = headers[i] * headers[j];
                    maxWidth = Math.max(maxWidth, getCellWidth(product));
                }
            }
            maxWidth = Math.max(maxWidth, 2);

            printWriter.printf("%" + (maxWidth + 1) + "s", "");
            for (int j = 0; j < n; j++) {
                printWriter.printf("%" + (maxWidth + 2) + "d", headers[j]);
            }
            printWriter.println();

            for (int i = 0; i < n; i++) {
                printWriter.printf("%" + (maxWidth + 1) + "d", headers[i]);
                for (int j = 0; j < n; j++) {
                    printWriter.printf("%" + (maxWidth + 2) + "d", headers[i] * headers[j]);
                }
                printWriter.println();
            }

            printWriter.flush();

        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}