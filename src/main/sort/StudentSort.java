package main.sort;

import main.model.Student;

public class StudentSort {
    private StudentSortStrategy studentSortStrategy;
    private Student[] students;

    public StudentSort(Student[] students, StudentSortStrategy studentSortStrategy) {
        this.studentSortStrategy = studentSortStrategy;
        this.students = studentSortStrategy.sort(students);
    }
    public void setStrategy(StudentSortStrategy strategy){
        this.studentSortStrategy = strategy;
        this.students = studentSortStrategy.sort(students);
    }
    public Student[] getStudents() {
        return students;
    }





}
