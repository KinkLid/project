package org.teamwork.sort;


import org.teamwork.model.Student;
import java.util.*;


public class ByEvenNumberedStrategy extends AbstractMergeSort {
    @Override
    public List<Student> sort(List<Student> students) {
        List<Student> evens = students.stream()
                .filter(s -> s.getGroupNumber() % 2 == 0)
                .toList();


        List<Student> sorted = mergeSort(new ArrayList<>(evens),
                Comparator.comparingInt(Student::getGroupNumber)
                        .thenComparingDouble(Student::getAverageGrade)
                        .thenComparing(Student::getRecordBookNumber));


        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGroupNumber() % 2 == 0)
                students.set(i, sorted.get(index++));
        }


        return students;
    }
}