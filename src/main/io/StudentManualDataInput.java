package main.io;

import main.Student;

public class StudentManualDataInput extends AbstractManualDataInput <Student> {

    @Override
    protected Student createObject() {
        System.out.println("Введите номер группы (int): ");
        int groupNum = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите среднюю оценку (double): ");
        double avgGrade = scanner.nextDouble();

        System.out.println("Введите номер зачетной книжки (String): ");
        String recordBookNum = scanner.nextLine();
        scanner.nextLine(); // Очистка буфера

        return new Student().Builder()
                .setGroupNumber(groupNum)
                .setAverageGrade(avgGrade)
                .setRecordBookNumber(recordBookNum)
                .build();
    }
}
