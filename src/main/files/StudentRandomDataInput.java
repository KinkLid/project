package org.teamwork.io;


import org.teamwork.model.Student;
import org.teamwork.collections.StudentList;
import java.util.stream.IntStream;


public class StudentRandomDataInput extends AbstractRandomDataInput<Student> {


    @Override
    protected Student createRandomObject() {
        int group = 1 + random.nextInt(50);
        double avg = 1.0 + random.nextDouble(4.0);
        String record = (1 + random.nextInt(999)) + "/" + (1 + random.nextInt(99));


        return new Student.Builder()
                .groupNumber(group)
                .averageGrade(avg)
                .recordBookNumber(record)
                .build();
    }


    @Override
    public StudentList createRandomInput(int length) {
        return IntStream.range(0, length)
                .mapToObj(i -> createRandomObject())
                .collect(StudentList::new, StudentList::add, StudentList::addAll);
    }
}