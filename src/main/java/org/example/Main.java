package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет! Давайте поиграем в игру \"Угадай число\"!");

        boolean play = true;
        while (play) {
            System.out.println("В каком диапазоне мне загадать число?");
            int min = inputInt("Введите значение \"от\":");
            int max = inputInt("Введите значение \"до\":");
            int attempt = inputInt("Введите желаемое количество попыток:");
            int random = randomInt(min, max);
            game(min, max, attempt, random);

            System.out.println("Хотите сыграть ещё разок?");
            while (true) {
                int playAgain = inputInt("0 - \"Нет\"\n1 - \"Да\"");
                if (playAgain == 0) {
                    play = false;
                    break;
                } else if (playAgain != 1) {
                    System.out.println("Не корректный ввод, попробуйте ещё раз.");
                } else {
                    System.out.println("Отлично, давайте повторим!");
                    break;
                }
            }
        }
        System.out.println("Спасибоа за игру!\nДо новых встречь!");

    }

    private static int inputInt(String text) {
        int input;
        while (true) {
            System.out.println(text);
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                break;
            } else {
                System.out.println("Вы ввели неверное значение, попробуйте ещё раз.");
            }
        }
        return input;
    }

    private static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private static void game(int min, int max, int attempt, int random) {
        System.out.println("Я загадал число от " + min + " до " + max + "!\nКоличество попыток его угадать: " + attempt);
        for (int i = 1; i <= attempt; i++) {
            System.out.println("Попытка №" + i);
            int input = inputInt("Введите число:");
            if (input > random) System.out.println("Меньше...");
            if (input < random) System.out.println("Больше...");
            if (input == random) {
                System.out.println("Вы угадали число с попытки №" + i + ", поздравляю!");
                return;
            }
        }
        System.out.println("Все попытки исчерпаны.");
    }
}
