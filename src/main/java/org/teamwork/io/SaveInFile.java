package org.teamwork.io;



import org.teamwork.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveInFile {

//    Задание: реализовать функционал для записи отсортированных коллекций/найденных значений в файл в режиме добавления данных
//
//    Нужно добавить в пакет io класс, который записывает список студентов в файл через FileWriter(path, true)

    protected static final String OUTPUT_PATH = "src/test/resources/";

    // метод для записи в файл. fileName имя самого файла, без пути, ArrayList - отсортированная коллекция элементов
    public static void save(String fileName, ArrayList<Student> students) throws IOException
    {
        String filePath = OUTPUT_PATH + fileName;
        FileWriter writer = new FileWriter(filePath);
        for (Student student : students) {
            writer.write(Integer.toString(student.getGroupNumber()) + ", ");
            writer.write(Double.toString(student.getAverageGrade()) + ", ");
            writer.write(student.getRecordBookNumber() + "\n");
        }
        writer.close();
    }
}
