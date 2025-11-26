package org.teamwork.multithreadsearch;

import org.teamwork.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {

	public static List<Student> readStudentsFromFile(String fileName) throws IOException {
		List<Student> students = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				// Пропускаем пустые строки
				if (line.trim().isEmpty()) continue;

				String[] parts = line.split(",");

				if (parts.length >= 3) {
					try {
						int group = Integer.parseInt(parts[0].trim());
						double grade = Double.parseDouble(parts[1].trim());
						String recordBook = parts[2].trim();

						Student student = new Student.Builder()
								.groupNumber(group)
								.averageGrade(grade)
								.recordBookNumber(recordBook)
								.build();

						students.add(student);

					} catch (NumberFormatException e) {
						System.err.println("Ошибка парсинга строки: " + line);
					}
				}
			}
		}
		return students;
	}
}
