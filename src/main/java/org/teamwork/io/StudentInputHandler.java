package org.teamwork.io;

import org.teamwork.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Класс для обработки ввода данных о студентах
public class StudentInputHandler extends AbstractInputHandler<Student> {

    @Override
    protected ArrayList<Student> manualInput(int length, Scanner scanner) {
        AbstractManualDataInput<Student> studentInput = new StudentManualDataInput();
        return studentInput.manualDataInputArray(length, scanner);
    }

    @Override
    protected ArrayList<Student> randomInput(int length) {
        AbstractRandomDataInput<Student> studentInput = new StudentRandomDataInput();
        return studentInput.createRandomInputArray(length);
    }

    @Override
    protected ArrayList<Student> fileInput(String filePath) throws IOException {
        AbstractFileDataInput<Student> studentInput = new StudentFileDataInput();
        return studentInput.readFromFile(filePath);
    }

    // Публичные методы для использования в TUI
    public ArrayList<Student> getManualInput(int length, Scanner scanner) {
        return manualInput(length, scanner);
    }

    public ArrayList<Student> getRandomInput(int length) {
        return randomInput(length);
    }

    public ArrayList<Student> getFileInput(String filePath) throws IOException {
        return fileInput(filePath);
    }
}
