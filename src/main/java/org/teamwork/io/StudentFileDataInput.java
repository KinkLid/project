package org.teamwork.io;

import org.teamwork.model.Student;
import org.teamwork.validation.StudentValidator;

public class StudentFileDataInput extends AbstractFileDataInput<Student> {
    // Парсинг строки, содержащей данные о студентах
    // Строка должна содержать Номер группы, Средний балл и Номер зачетной книжки

    @Override
    protected Student parseLine(String[] parts) throws NumberFormatException, IllegalArgumentException {
        if (parts.length < 3) {
            throw new IllegalArgumentException("Недостаточно данных в строке. Ожидается: номер группы, средний балл, номер зачётной книжки.");
        }

        int groupNum = Integer.parseInt(parts[0].trim());
        double avgGrade = Double.parseDouble(parts[1].trim());
        String recordBookNum = parts[2].trim();

        StudentValidator.validateGroupNumber(groupNum);
        StudentValidator.validateAverageGrade(avgGrade);
        StudentValidator.validateRecordBookNumber(recordBookNum);

        return Student.Builder()
                .setGroupNumber(groupNum)
                .setAverageGrade(avgGrade)
                .setRecordBookNumber(recordBookNum)
                .build();
    }
}
