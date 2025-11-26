package org.teamwork.sort;


import org.teamwork.model.Student;
import java.util.Comparator;
import java.util.List;


public class ByAverageGradeStrategy extends AbstractMergeSort {
    @Override
    public List<Student> sort(List<Student> students) {
        return mergeSort(students,
                Comparator.comparingInt(Student::getGroupNumber)
                        .thenComparingDouble(Student::getAverageGrade));
    }
}