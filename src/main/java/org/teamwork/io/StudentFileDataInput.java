package org.teamwork.io;


import org.teamwork.model.Student;
import org.teamwork.validation.InputValidator;

public class StudentFileDataInput extends AbstractFileDataInput<Student> {
    // Парсинг строки, содержащей данные о студентах
    // Строка должна содержать Номер группы, Средний балл и Номер зачетной книжки

    @Override
    protected Student parseLine(String[] parts) {
        if (parts.length < 3) {
            throw new IllegalArgumentException("Недостаточно данных для создания студента: " 
                                            + String.join(", ", parts));
        }

        try {
            int groupNum = Integer.parseInt(parts[0].trim());
            double avgGrade = Double.parseDouble(parts[1].trim());
            String recordBookNum = parts[2].trim();

            InputValidator.validateGroupNumber(groupNum);
            InputValidator.validateAverageGrade(avgGrade);
            InputValidator.validateRecordBookNumber(recordBookNum);
            return new Student.Builder()
                    .groupNumber(groupNum)
                    .averageGrade(avgGrade)
                    .recordBookNumber(recordBookNum)
                    .build();
        } catch (NumberFormatException e) {
            // Здесь мы превращаем NumberFormatException в IllegalArgumentException
            throw new IllegalArgumentException(
                    "Ошибка формата числового поля в строке: " + String.join(", ", parts),
                    e // cause — чтобы не потерять стек трейc
            );
        }
    }
}