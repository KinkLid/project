package main.sort;

import main.model.Student;

public interface StudentSortStrategy {
    public Student[] sort(Student[] students);
}
