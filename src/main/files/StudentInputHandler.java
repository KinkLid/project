package org.teamwork.io;


import org.teamwork.collections.StudentList;
import org.teamwork.model.Student;
import java.io.IOException;
import java.util.Scanner;


public class StudentInputHandler extends AbstractInputHandler<StudentList> {


    @Override
    protected StudentList manualInput(int length, Scanner scanner) {
        return new StudentManualDataInput().manualInputList(length, scanner);
    }


    @Override
    protected StudentList randomInput(int length) {
        return new StudentRandomDataInput().createRandomInput(length);
    }


    @Override
    protected StudentList fileInput(String filePath) throws IOException {
        return new StudentFileDataInput().readAsList(filePath);
    }
}