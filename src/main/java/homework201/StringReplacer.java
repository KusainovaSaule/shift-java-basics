package main.java.homework201;

import java.util.Scanner;

public class StringReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        System.out.print("Введите символ (кроме пробела), все вхождения которого нужно заменить на пробел: ");
        String searchSymbol = scanner.nextLine();

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

        String originalInputString = inputString;

        String fixedString = fixSpaces(inputString);

        String replacedString = fixedString.replace(searchSymbol, " ");

        String result = fixSpaces(replacedString);

        System.out.println("Исходная строка: " + originalInputString);
        System.out.println("Результат: " + result);

        if (result.equals(originalInputString)) {
            System.out.println("Строка не изменилась после преобразований");
        }

        scanner.close();
    }

    public static String fixSpaces(String input) {
        StringBuilder result  = new StringBuilder();

        boolean lastWasSpace = false;

        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);

            if (x == ' ') {
                if (!lastWasSpace) {
                    result.append(x);
                    lastWasSpace = true;
                }
            }
            else {
                result.append(x);
                lastWasSpace = false;
            }
        }

        return result.toString();
    }
}
