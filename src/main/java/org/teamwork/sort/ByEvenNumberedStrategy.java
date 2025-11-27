package org.teamwork.sort;

import org.teamwork.model.Student;
import java.util.Arrays;

public class ByEvenNumberedStrategy extends AbstractMergeSort {

    @Override
    public Student[] sort(Student[] students) {
        if (students == null) return null;

        boolean exist = Arrays.stream(students)
                .map(Student::getGroupNumber)
                .anyMatch(s -> (s % 2) != 1);

        if (exist) {
            Student[] evenNumbers = Arrays.stream(students)
                    .filter(s -> (s.getGroupNumber() % 2) != 1)
                    .toArray(Student[]::new);

            evenNumbers = super.splitting(evenNumbers);

            int count = 0;

            for(int i = 0; i < students.length; i++){
                if (students[i].getGroupNumber() % 2 != 1){
                    students[i] = evenNumbers[count++];
                    if(count == evenNumbers.length) {
                        break;
                    }
                }
            }
            return students;
        }
        return students;
    }
}
