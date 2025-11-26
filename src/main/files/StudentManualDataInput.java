package org.teamwork.io;


import org.teamwork.collections.StudentList;
import org.teamwork.model.Student;
import org.teamwork.validation.InputValidator;
import java.util.Scanner;
import java.util.stream.IntStream;


public class StudentManualDataInput extends AbstractManualDataInput<Student> {


    @Override
    protected Student createObject(Scanner scanner) {
        System.out.print("Введите номер группы: ");
        int group = scanner.nextInt();
        scanner.nextLine();
        InputValidator.validateGroupNumber(group);


        System.out.print("Введите среднюю оценку: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();
        InputValidator.validateAverageGrade(grade);


        System.out.print("Введите номер зачётной книжки: ");
        String record = scanner.nextLine();
        InputValidator.validateRecordBookNumber(record);


        return new Student.Builder()
                .groupNumber(group)
                .averageGrade(grade)
                .recordBookNumber(record)
                .build();
    }


    @Override
    public StudentList manualInputList(int length, Scanner scanner) {
        return IntStream.range(0, length)
                .mapToObj(i -> createObject(scanner))
                .collect(StudentList::new, StudentList::add, StudentList::addAll);
    }
}