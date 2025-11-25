package main.io;

import main.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveInFile {

//    Задание: реализовать функционал для записи отсортированных коллекций/найденных значений в файл в режиме добавления данных
//
//    Нужно добавить в пакет io класс, который записывает список студентов в файл через FileWriter(path, true)

    protected static final String OUTPUT_PATH = "src/test/resources/saveInFile/";

    // метод для записи в файл. fileName имя самого файла, без пути, ArrayList - отсортированная коллекция элементов
    public static void save(String fileName, ArrayList<Student> students) throws IOException
    {
        String filePath = OUTPUT_PATH + fileName;
        FileWriter writer = new FileWriter(filePath, true);
        for(int i = 0; i < students.size(); i++)
        {
            writer.write(Integer.toString(students.get(i).getGroupNumber()) + ", ");
            writer.write(Double.toString(students.get(i).getAverageGrade()) + ", ");
            writer.write(students.get(i).getRecordBookNumber() + "\n");
        }
        writer.close();
    }
}
