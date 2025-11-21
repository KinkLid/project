package main.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractFileDataInput <T> {

    // Метод для парсинга строки данных и преобразования их в объект типа T

    protected abstract T parseLine(String[] parts) throws NumberFormatException;

    // Чтение данных из файла и преобразование их в список объектов типа T
    // Каждая строка в файле должна представлять собой набор данных, разделенный запятой.
    // Ошибки при обработке строки (например, неправильный формат данных) будут выводиться в консоль.

    public ArrayList<T> readFromFile(String filePath) throws IOException {
        ArrayList<T> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;  // Пропускаем пустые строки
                }
                String[] parts = line.split(",");  // Разделяем строку по запятой
                try {
                    T item = parseLine(parts);  // Преобразуем строку в объект
                    items.add(item);
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка обработки строки: " + line + ". Причина: " + e.getMessage());
                }
            }
        }
        return items;
    }

}
