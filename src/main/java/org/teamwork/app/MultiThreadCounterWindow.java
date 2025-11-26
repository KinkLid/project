package org.teamwork.app;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import org.teamwork.model.Student;
import org.teamwork.multithreadsearch.MultiThreadSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MultiThreadCounterWindow extends BasicWindow {

	// Ссылка на список студентов
	private final List<Student> students;

	public MultiThreadCounterWindow(ArrayList<Student> students) {
		super("Многопоточный поиск студента");
		this.students = students;

		// Панель содержимого с сеткой в 2 колонки
		Panel contentPanel = new Panel(new GridLayout(2));

		// Поля для ввода параметров
		contentPanel.addComponent(new Label("Номер группы:"));
		TextBox groupBox = new TextBox().setValidationPattern(Pattern.compile("[0-9]*"));
		contentPanel.addComponent(groupBox);

		contentPanel.addComponent(new Label("Средний балл:"));
		// Разрешаем ввод дробных чисел
		TextBox gradeBox = new TextBox().setValidationPattern(Pattern.compile("[0-9]*\\.?[0-9]*"));
		contentPanel.addComponent(gradeBox);

		contentPanel.addComponent(new Label("№ Зачетной книжки:"));
		TextBox recordBookBox = new TextBox();
		contentPanel.addComponent(recordBookBox);

		// Настройки потоков
		contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));
		contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		contentPanel.addComponent(new Label("Кол-во потоков:"));
		TextBox threadsBox = new TextBox("4").setValidationPattern(Pattern.compile("[0-9]*"));
		contentPanel.addComponent(threadsBox);

		contentPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		// Кнопка запуска
		Button runButton = new Button("Найти", () -> {
			try {
				// Валидация
				if (groupBox.getText().isEmpty() || gradeBox.getText().isEmpty() || recordBookBox.getText().isEmpty()) {
					MessageDialog.showMessageDialog(getTextGUI(), "Ошибка", "Заполните все поля!", MessageDialogButton.OK);
					return;
				}

				// Парсинг данных
				int group = Integer.parseInt(groupBox.getText());
				double grade = Double.parseDouble(gradeBox.getText());
				String recordBook = recordBookBox.getText();

				int threads = 1;
				if (!threadsBox.getText().isEmpty()) {
					threads = Integer.parseInt(threadsBox.getText());
				}

				// Создаем объект-образец для поиска
				Student target = new Student(group, grade, recordBook);

				// Вызов логики
				long startTime = System.currentTimeMillis();
				int count = MultiThreadSearch.countStudentOccurrences(this.students, target, threads);
				long endTime = System.currentTimeMillis();

				// Вывод результата
				String msg = String.format("Найдено: %d\nВремя: %d мс\nПотоков: %d", count, (endTime - startTime), threads);
				MessageDialog.showMessageDialog(getTextGUI(), "Результат", msg, MessageDialogButton.OK);

			} catch (NumberFormatException e) {
				MessageDialog.showMessageDialog(getTextGUI(), "Ошибка", "Проверьте правильность чисел", MessageDialogButton.OK);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (Exception e) {
				MessageDialog.showMessageDialog(getTextGUI(), "Ошибка", e.getMessage(), MessageDialogButton.OK);
			}
		});

		// Размещаем кнопку по центру
		contentPanel.addComponent(runButton.setLayoutData(
				GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER, true, false, 2, 1)));

		// Кнопка "Назад"
		Button closeButton = new Button("Назад", this::close);
		contentPanel.addComponent(closeButton.setLayoutData(
				GridLayout.createLayoutData(GridLayout.Alignment.CENTER, GridLayout.Alignment.CENTER, true, false, 2, 1)));

		setComponent(contentPanel);
	}
}