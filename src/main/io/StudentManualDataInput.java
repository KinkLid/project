package main.io;

import main.Student;
import main.validation.StudentValidator;

public class StudentManualDataInput extends AbstractManualDataInput <Student> {

    @Override
    protected Student createObject() {
        IO.println("Введите номер группы (int): ");
        int groupNum = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        StudentValidator.validateGroupNumber(groupNum);

        IO.println("Введите среднюю оценку (double): ");
        double avgGrade = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        StudentValidator.validateAverageGrade(avgGrade);

        IO.println("Введите номер зачетной книжки (String): ");
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
