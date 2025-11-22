package org.teamwork.validation;

import org.teamwork.model.Student;

/** Класс для валидации данных студентов. */
public class StudentValidator {
    /**
     * Валидирует номер группы.
     * @param groupNumber номер группы
     * @throws IllegalArgumentException если номер группы невалиден
     */
    public static void validateGroupNumber(int groupNumber) {
        if (groupNumber <= 0) {
            throw new IllegalArgumentException("Номер группы должен быть положительным числом. Получено: " + groupNumber);
        }
    }

    /**
     * Валидирует среднюю оценку.
     * @param averageGrade средняя оценка
     * @throws IllegalArgumentException если оценка невалидна
     */
    public static void validateAverageGrade(double averageGrade) {
        if (averageGrade < 1 || averageGrade > 5) {
            throw new IllegalArgumentException(
                    String.format("Средняя оценка должна быть в диапазоне от 1 до 5. Получено: %.2f", averageGrade));
        }
    }

    /**
     * Валидирует номер зачетной книжки.
     * @param recordBookNumber номер зачетной книжки
     * @throws IllegalArgumentException если номер зачетной книжки невалиден
     */
    public static void validateRecordBookNumber(String recordBookNumber) {
        if (recordBookNumber == null || recordBookNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер зачетной книжки не может быть пустым");
        }
    }

    /**
     * Валидирует все поля студента.
     * @param groupNumber номер группы
     * @param averageGrade средняя оценка
     * @param recordBookNumber номер зачетной книжки
     * @throws IllegalArgumentException если хотя бы одно поле невалидно
     */
    public static void validateStudent(int groupNumber, double averageGrade, String recordBookNumber) {
        validateGroupNumber(groupNumber);
        validateAverageGrade(averageGrade);
        validateRecordBookNumber(recordBookNumber);
    }

    /**
     * Валидирует объект Student.
     * @param student объект студента
     * @throws IllegalArgumentException если данные студента невалидны
     */
    public static void validateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент не может быть null");
        }
        validateStudent(student.getGroupNumber(), student.getAverageGrade(), student.getRecordBookNumber());
    }
}
