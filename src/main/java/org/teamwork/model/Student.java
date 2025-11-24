package org.teamwork.model;

public class Student {
    int groupNumber;
    double averageGrade;
    String recordBookNumber;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Student student = (Student) obj;

        return (groupNumber == student.groupNumber) &&
                (averageGrade == student.averageGrade) &&
                (recordBookNumber.equals(student.recordBookNumber));
    }

    public Student(int groupNumber, double averageGrade, String recordBookNumber) {
        this.groupNumber = groupNumber;
        this.averageGrade = averageGrade;
        this.recordBookNumber = recordBookNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }
}
