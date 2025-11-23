package org.teamwork.io;

import org.teamwork.model.Student;

public class StudentManualDataInput extends AbstractManualDataInput <Student> {
	@Override
	protected Student createObject() {
		IO.println("Введите номер группы (int): ");
		int groupNum = scanner.nextInt();
		scanner.nextLine(); // Очистка буфера

		IO.println("Введите среднюю оценку (double): ");
		double avgGrade = scanner.nextDouble();

		IO.println("Введите номер зачетной книжки (String): ");
		String recordBookNum = scanner.nextLine();
		scanner.nextLine(); // Очистка буфера

		return new Student().Builder()
				.setGroupNumber(groupNum)
				.setAverageGrade(avgGrade)
				.setRecordBookNumber(recordBookNum)
				.build();
	}
}
