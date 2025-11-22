package org.teamwork.io;

import org.teamwork.model.Student;
import org.teamwork.validation.StudentValidator;

public class StudentManualDataInput extends AbstractManualDataInput <Student> {

    @Override
    protected Student createObject() {
        System.out.println("Введите номер группы (int): ");
        int groupNum = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        StudentValidator.validateGroupNumber(groupNum);

        System.out.println("Введите среднюю оценку (double): ");
        double avgGrade = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        StudentValidator.validateAverageGrade(avgGrade);

        System.out.println("Введите номер зачетной книжки (String): ");
        String recordBookNum = scanner.nextLine();
        scanner.nextLine(); // Очистка буфера
        StudentValidator.validateRecordBookNumber(recordBookNum);

        return Student.Builder()
                .setGroupNumber(groupNum)
                .setAverageGrade(avgGrade)
                .setRecordBookNumber(recordBookNum)
                .build();
    }
}
