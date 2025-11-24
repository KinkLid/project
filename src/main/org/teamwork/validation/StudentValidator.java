package org.teamwork.validation;

public class StudentValidator {

    public static void validate(Student student) {

        if (student.getGroupNumber() <= 0) {
            throw new IllegalArgumentException("Номер группы должен быть > 0");
        }

        if (student.getAverageGrade() < 0.0 || student.getAverageGrade() > 10.0) {
            throw new IllegalArgumentException("Средняя оценка должна быть в диапазоне 0.0 - 10.0");
        }

        String rec = student.getRecordBookNumber();
        if (rec == null || rec.isBlank()) {
            throw new IllegalArgumentException("Номер зачетной книжки не может быть пустым");
        }

        if (!rec.matches("[A-Za-z0-9\\-]+")) {
            throw new IllegalArgumentException("Номер зачетки должен содержать только латинские буквы, цифры или тире");
        }
    }
}
