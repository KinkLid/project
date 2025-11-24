package org.teamwork.model;

public class Student {

    private final int groupNumber;
    private final double averageGrade;
    private final String recordBookNumber;

    private Student(Builder builder) {
        this.groupNumber = builder.groupNumber;
        this.averageGrade = builder.averageGrade;
        this.recordBookNumber = builder.recordBookNumber;
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

    @Override
    public String toString() {
        return "Student{" +
                "groupNumber=" + groupNumber +
                ", averageGrade=" + averageGrade +
                ", recordBookNumber='" + recordBookNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        if (groupNumber != student.groupNumber) return false;
        if (Double.compare(student.averageGrade, averageGrade) != 0) return false;
        return recordBookNumber.equals(student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        int result;
        result = groupNumber;
        result = 31 * result + Double.hashCode(averageGrade);
        result = 31 * result + recordBookNumber.hashCode();
        return result;
    }

    public static class Builder {

        private int groupNumber;
        private double averageGrade;
        private String recordBookNumber;

        public Builder groupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder averageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
            return this;
        }

        public Builder recordBookNumber(String recordBookNumber) {
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build() {
            Student student = new Student(this);
            StudentValidator.validate(student);
            return student;
        }
    }
}
