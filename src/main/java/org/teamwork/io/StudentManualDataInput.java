package org.teamwork.io;

import org.teamwork.model.Student;
import org.teamwork.validation.InputValidator;
import org.teamwork.validation.StudentValidator;

import java.util.Scanner;

public class StudentManualDataInput extends AbstractManualDataInput <Student> {

    @Override
    protected Student createObject(Scanner scanner) {
        IO.println("Введите номер группы (int): ");
        int groupNum = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        InputValidator.validateGroupNumber(groupNum);

        IO.println("Введите среднюю оценку (double): ");
        double avgGrade = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        InputValidator.validateAverageGrade(avgGrade);

        IO.println("Введите номер зачетной книжки (String): ");
        String recordBookNum = scanner.nextLine();
        scanner.nextLine(); // Очистка буфера
        InputValidator.validateRecordBookNumber(recordBookNum);

        return new Student.Builder()
                .groupNumber(groupNum)
                .averageGrade(avgGrade)
                .recordBookNumber(recordBookNum)
                .build();
    }
}
