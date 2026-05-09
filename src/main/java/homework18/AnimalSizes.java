package main.java.homework18;

public class AnimalSizes {
    public static void main(String[] args) {
        int boaLengthCm = 380;
        int boaInParrots = 38;
        int boaInMonkeys = 5;
        int boaInElephants = 2;

        double boaLengthM = boaLengthCm / 100.0;
        double parrotHeightM = (double) boaLengthCm / boaInParrots / 100;
        double monkeyHeightM = (double) boaLengthCm / boaInMonkeys / 100;
        double elephantHeightM = (double) boaLengthCm / boaInElephants / 100;
        double totalHeight = boaLengthM + parrotHeightM + monkeyHeightM + elephantHeightM;

        System.out.printf("Рост удава: %.2f м%n", boaLengthM);
        System.out.printf("Рост попугая: %.2f м%n", parrotHeightM);
        System.out.printf("Рост мартышки: %.2f м%n", monkeyHeightM);
        System.out.printf("Рост слонёнка: %.2f м%n", elephantHeightM);
        System.out.printf("Суммарный рост всех персонажей: %.2f м%n", totalHeight);
    }
}