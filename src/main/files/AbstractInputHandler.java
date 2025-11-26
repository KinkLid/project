package org.teamwork.io;


import java.io.IOException;
import java.util.Scanner;


public abstract class AbstractInputHandler<T> {


    protected T inputArray;
    protected final String OUTPUT_PATH = "src/main/resources/";


    public T getInputArray() { return inputArray; }


    public void handleInput(Scanner scanner) {
        while (true) {
            System.out.println("Выберите способ ввода:");
            System.out.println("1 - файл");
            System.out.println("2 - случайные данные");
            System.out.println("3 - вручную");
            System.out.println("0 - отмена");


            int choice = scanner.nextInt();
            scanner.nextLine();


            try {
                switch (choice) {
                    case 1 -> inputArray = fileInput(OUTPUT_PATH + scanner.nextLine() + ".txt");
                    case 2 -> {
                        System.out.print("Введите количество: ");
                        int len = scanner.nextInt();
                        scanner.nextLine();
                        inputArray = randomInput(len);
                    }
                    case 3 -> {
                        System.out.print("Введите количество: ");
                        int len = scanner.nextInt();
                        scanner.nextLine();
                        inputArray = manualInput(len, scanner);
                    }
                    case 0 -> { return; }
                    default -> System.out.println("Неверный ввод!");
                }
                return;


            } catch (IOException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }


    protected abstract T manualInput(int length, Scanner scanner);
    protected abstract T randomInput(int length);
    protected abstract T fileInput(String filePath) throws IOException;
}