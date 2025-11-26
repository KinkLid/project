package org.teamwork.io;


import org.teamwork.model.Student;
import org.teamwork.validation.InputValidator;
import org.teamwork.collections.StudentList;
import java.util.List;
import java.util.ArrayList;


public class StudentFileDataInput extends AbstractFileDataInput<Student> {


    @Override
    protected Student parseLine(String[] parts) {
        int group = Integer.parseInt(parts[0].trim());
        double grade = Double.parseDouble(parts[1].trim());
        String record = parts[2].trim();


        InputValidator.validateGroupNumber(group);
        InputValidator.validateAverageGrade(grade);
        InputValidator.validateRecordBookNumber(record);


        return new Student.Builder()
                .groupNumber(group)
                .averageGrade(grade)
                .recordBookNumber(record)
                .build();
    }


    @Override
    public StudentList readAsList(String filePath) throws java.io.IOException {
        List<Student> loaded = super.readFromFile(filePath);
        StudentList list = new StudentList();
        list.addAll(loaded);
        return list;
    }
}