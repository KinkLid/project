package org.teamwork.sort;

import org.teamwork.model.Student;

public class ByEvenNumberedStrategy extends AbstractMergeSort{
    @Override
    public Student[] sort(Student[] students) {
        if (students == null) return null;

        int count = 0;
        for (Student student : students) {
            if (student.getGroupNumber() % 2 != 1) {
                count++;
            }
        }

        if (count != 0) {
            Student[] evenNumbers = new Student[count];
            count = 0;
            for (Student student : students) {
                if (student.getGroupNumber() % 2 != 1) {
                    evenNumbers[count] = student;
                    count++;
                }
            }

            evenNumbers = super.splitting(evenNumbers);

            count = 0;

            for(int i = 0; i < students.length; i++){
                if (students[i].getGroupNumber() % 2 != 1){
                    students[i] = evenNumbers[count];
                    count++;
                    if(count == evenNumbers.length) break;
                }
            }
            return students;
        }
        return students;
    }

}