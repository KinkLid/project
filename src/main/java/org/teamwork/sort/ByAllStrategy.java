package org.teamwork.sort;

import org.teamwork.model.Student;

public class ByAllStrategy extends AbstractMergeSort {
    @Override
    public Student[] sort(Student[] students){
        if(students == null) return null;
        return super.splitting(students);

    }
}
