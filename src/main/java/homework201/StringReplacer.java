package main.java.homework201;

import java.util.Scanner;

public class StringReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        System.out.print("Введите символ (кроме пробела), все вхождения которого нужно заменить на пробел: ");
        String searchSymbol = scanner.nextLine();

        if (!inputString.matches("[a-zA-Zа-яА-Я .,?!:;]*")) {
            System.out.println("Ошибка! Строка содержит недопустимые символы");
            scanner.close();
            return;
        }

        if (inputString.isEmpty() || inputString.length() == 1) {
            System.out.print("Ошибка! Строка нулевой или единичной длины");
            scanner.close();
            return;
        }

        if (searchSymbol.length() != 1 || searchSymbol.equals(" ")) {
            System.out.print("Ошибка! Символ является пробелом или длина символов больше 1");
            scanner.close();
            return;
        }

        String result = fixSpaces(inputString);
        result = result.replace(searchSymbol, " ");
        result = fixSpaces(result);

        System.out.println("Исходная строка: " + inputString);
        System.out.println("Результат: " + result);

        if (result.equals(inputString)) {
            System.out.println("Строка не изменилась после преобразований");
        }

        scanner.close();
    }

    public static String fixSpaces(String input) {
        return input.replaceAll("\\s+", " ");
    }
}