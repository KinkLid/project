package org.teamwork.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Абстрактный класс для взаимодействия с пользователем, определения способа ввода и длины массива элементов.
public abstract class AbstractInputHandler <T>{

    protected ArrayList<T> inputArray; // неотсортированная коллекция элементов, введенных пользователем

    protected final String OUTPUT_INPUT_PATH = "src/main/resources/"; // путь для работы с файлами


    public ArrayList<T> getInputArray()
    {
        return inputArray;
    }

    //Метод, обрабатывающий выбор пользователя для ввода данных (из файла, случайных данных или вручную)
    public void handleInput(Scanner scanner) {

        boolean isInputIncorrect = false;
        do { // заставляем пользователя сделать правильный выбор)))
            System.out.println("Выберите способ ввода данных:");
            System.out.println("1 - ввод из файла");
            System.out.println("2 - ввод случайных данных");
            System.out.println("3 - ввод данных вручную");
            System.out.println("0 - Отмена. Выход из функции");

            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1 -> {
                        isInputIncorrect = false;
                        inputArray = handleTextInputArray(scanner);
                    }
                    case 2 -> {
                        isInputIncorrect = false;
                        inputArray = handleRandomInputArray(scanner);
                    }
                    case 3 -> {
                        isInputIncorrect = false;
                        inputArray = handleManualInputArray(scanner);
                    }
                    case 0 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Неверный выбор. Повторите попытку.");
                        isInputIncorrect = true;
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } while (isInputIncorrect);
    }

    // Обработка ввода данных вручную, создание списка и его печать.
    private ArrayList<T> handleManualInputArray (Scanner scanner) {
        int length;
        try {
            System.out.print("Введите количество элементов: ");
            length = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
        } catch (InputMismatchException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        return manualInput(length, scanner);
    }

    // Обработка ввода данных из файла
    private ArrayList<T> handleTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла: ");
        String filePath = OUTPUT_INPUT_PATH + scanner.next() + ".txt";
        scanner.nextLine();

        return fileInput(filePath);
    }

    // Обработка ввода случайных данных
    private ArrayList<T> handleRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество элементов: ");
        int length;
        try {
            System.out.print("Введите количество элементов: ");
            length = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
        } catch (InputMismatchException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
        scanner.nextLine();

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        return randomInput(length);
    }

    // Три метода для ввода данных, по одному для каждого способа ввода.
    protected abstract ArrayList<T> manualInput(int length, Scanner scanner);
    protected abstract ArrayList<T> randomInput(int length);
    protected abstract ArrayList<T> fileInput(String filePath) throws IOException;

}
