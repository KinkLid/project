package main.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Абстрактный класс для взаимодействия с пользователем, определения способа ввода и длины массива элементов.
public abstract class AbstractInputHandler <T>{

    protected final String OUTPUT_INPUT_PATH = "src/test/resources/"; // путь для работы с файлами

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
                        HandleTextInputArray(scanner);
                    }
                    case 2 -> {
                        isInputIncorrect = false;
                        HandleRandomInputArray(scanner);
                    }
                    case 3 -> {
                        isInputIncorrect = false;
                        handleManualInputArray(scanner);
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
    private void handleManualInputArray (Scanner scanner) {
        System.out.print("Введите количество элементов: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        ArrayList<T> items = manualInput(length);
    }

    // Обработка ввода данных из файла
    private void HandleTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла: ");
        String filePath = OUTPUT_INPUT_PATH + scanner.next() + ".txt";
        scanner.nextLine();

        ArrayList<T> items = fileInput(filePath);
    }

    // Обработка ввода случайных данных
    private void HandleRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество элементов: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        ArrayList<T> items = randomInput(length);
    }

    // Три метода для ввода данных, по одному для каждого способа ввода.
    protected abstract ArrayList<T> manualInput(int length);
    protected abstract ArrayList<T> randomInput(int length);
    protected abstract ArrayList<T> fileInput(String filePath) throws IOException;

}
