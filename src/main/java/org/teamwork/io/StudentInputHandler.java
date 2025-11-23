package org.teamwork.io;

import java.io.IOException;
import java.util.ArrayList;

import org.teamwork.model.Student;

// Класс для обработки ввода данных о студентах
public class StudentInputHandler extends AbstractInputHandler<Student> {
	@Override
	protected ArrayList<Student> manualInput(int length) {
		AbstractManualDataInput<Student> studentInput = new StudentManualDataInput();
		return studentInput.manualDataInputArray(length);
	}

	@Override
	protected ArrayList<Student> randomInput(int length) {
		AbstractRandomDataInput<Student> studentInput = new StudentRandomDataInput();
		return studentInput.createRandomInputArray(length);
	}

	@Override
	protected ArrayList<Student> fileInput(String filePath) throws IOException {
		AbstractFileDataInput<Student> studentInput = new StudentFileDataInput();
		return studentInput.readFromFile(filePath);
	}

	// Публичные методы для использования в TUI
	public ArrayList<Student> getManualInput(int length) {
		return manualInput(length);
	}

	public ArrayList<Student> getRandomInput(int length) {
		return randomInput(length);
	}

	public ArrayList<Student> getFileInput(String filePath) throws IOException {
		return fileInput(filePath);
	}
}
