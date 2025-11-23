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

		return (groupNumber == student.groupNumber || getGroupNumber() == student.getGroupNumber()) &&
				(averageGrade == student.averageGrade || getAverageGrade() == student.averageGrade) &&
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

	/**
	 * Создаёт новый Builder для построения объекта Student
	 * @return новый экземпляр StudentBuilder
	 */
	public static StudentBuilder Builder() {
		return new StudentBuilder();
	}
}
