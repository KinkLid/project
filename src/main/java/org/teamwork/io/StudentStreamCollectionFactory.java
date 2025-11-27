package org.teamwork.io;

import org.teamwork.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Использует StudentInputHandler как источник.
 */
public class StudentStreamCollectionFactory {

    private final StudentInputHandler inputHandler = new StudentInputHandler();

    /**
     * Ручной ввод через Stream API
     */
    public List<Student> createManualStreamCollection(int length, Scanner scanner) {
        // Stream API — создаём длину коллекции IntStream.range
        return IntStream.range(0, length)
                .mapToObj(i -> inputHandler.getManualInput(1, scanner).get(0))
                .collect(Collectors.toList());
    }

    /**
     * Рандомное заполнение через Stream API
     */
    public List<Student> createRandomStreamCollection(int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> inputHandler.getRandomInput(1).get(0))
                .collect(Collectors.toList());
    }

    /**
     * Заполнение из файла через Stream API
     */
    public List<Student> createFileStreamCollection(String filePath) throws IOException {
        ArrayList<Student> list = inputHandler.getFileInput(filePath);

        // Stream API — преобразуем в неизменяемый список или копию
        return list.stream()
                .collect(Collectors.toList());
    }
}
