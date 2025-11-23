package org.teamwork.io;

import org.teamwork.model.Student;

public class StudentRandomDataInput extends AbstractRandomDataInput <Student> {
	// Метод для случайного создания объекта типа Student

	protected Student createRandomObject() {
		int groupNum = 1 + random.nextInt(50); // Номер группы от 1 до 50
		double avgGrade = 1.0 + random.nextDouble() * 4.0; // Средняя оценка от 1 до 5

		StringBuilder sb = new StringBuilder();
		sb.append(1 + random.nextInt(999));
		sb.append("/");
		sb.append(1 + random.nextInt(99));
		String recordBookNum = sb.toString(); // номер зачетки

		return Student.Builder()
				.setGroupNumber(groupNum)
				.setAverageGrade(avgGrade)
				.setRecordBookNumber(recordBookNum)
				.build();
	}
}
