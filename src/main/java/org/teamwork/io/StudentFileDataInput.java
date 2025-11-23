package org.teamwork.io;

import org.teamwork.model.Student;

public class StudentFileDataInput extends AbstractFileDataInput<Student> {
	// Парсинг строки, содержащей данные о студентах
	// Строка должна содержать Номер группы, Средний балл и Номер зачетной книжки

	@Override
	protected Student parseLine(String[] parts) throws NumberFormatException {
		int groupNum = Integer.parseInt(parts[0].trim());
		double avgGrade = Double.parseDouble(parts[1].trim());
		String recordBookNum = parts[2].trim();
		return new Student().Builder()
				.setGroupNumber(groupNum)
				.setAverageGrade(avgGrade)
				.setRecordBookNumber(recordBookNum)
				.build();
	}
}
