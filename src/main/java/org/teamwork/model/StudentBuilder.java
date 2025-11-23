package org.teamwork.model;

/**
 * Builder для создания объектов Student с валидацией данных.
 */
public class StudentBuilder {
	private int groupNumber;
	private double averageGrade;
	private String recordBookNumber;

	public StudentBuilder() {
		// Пустой конструктор
	}

	public StudentBuilder setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
		return this;
	}

	public StudentBuilder setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
		return this;
	}

	public StudentBuilder setRecordBookNumber(String recordBookNumber) {
		this.recordBookNumber = recordBookNumber;
		return this;
	}

	/**
	 * Создает объект Student с валидацией данных.
	 * @return новый объект Student
	 * @throws IllegalArgumentException если данные невалидны
	 */
	public Student build() {
		validate();
		return new Student(groupNumber, averageGrade, recordBookNumber);
	}

	/**
	 * Валидация данных перед созданием объекта.
	 * @throws IllegalArgumentException если данные невалидны
	 */
	private void validate() {
		if (groupNumber <= 0) {
			throw new IllegalArgumentException("Номер группы должен быть положительным числом");
		}

		if (averageGrade < 1 || averageGrade > 5) {
			throw new IllegalArgumentException("Средняя оценка должна быть в диапазоне от 1 до 5");
		}

		if (recordBookNumber == null || recordBookNumber.trim().isEmpty()) {
			throw new IllegalArgumentException("Номер зачетной книжки не может быть пустым");
		}
	}
}
