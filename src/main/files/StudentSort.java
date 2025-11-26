package org.teamwork.sort;


import org.teamwork.model.Student;
import java.util.List;


public class StudentSort {
    private StudentSortStrategy strategy;
    private List<Student> students;


    public StudentSort(List<Student> students, StudentSortStrategy strategy) {
        this.strategy = strategy;
        this.students = strategy.sort(students);
    }


    public void setStrategy(StudentSortStrategy strategy) {
        this.strategy = strategy;
        this.students = strategy.sort(students);
    }


    public List<Student> getStudents() {
        return students;
    }
}