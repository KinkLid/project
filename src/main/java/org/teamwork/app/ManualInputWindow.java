package org.teamwork.app;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;

public class ManualInputWindow extends BasicWindow {
	private final int length;
	private final Consumer<ArrayList<Student>> onDataLoaded;
	private final ArrayList<Student> students;
	private int currentIndex = 0;

	private TextBox groupNumberBox;
	private TextBox averageGradeBox;
	private TextBox recordBookNumberBox;
	private Label statusLabel;

	public ManualInputWindow(int length, Consumer<ArrayList<Student>> onDataLoaded) {
		super("Ручной ввод данных");
		this.length = length;
		this.onDataLoaded = onDataLoaded;
		this.students = new ArrayList<>();

		createInputForm();
	}

	private void createInputForm() {
		Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));

		statusLabel = new Label(String.format("Введите данные студента %d из %d:", currentIndex + 1, length));
		panel.addComponent(statusLabel);
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		panel.addComponent(new Label("Номер группы (int):"));
		groupNumberBox = new TextBox(new TerminalSize(20, 1));
		panel.addComponent(groupNumberBox);

		panel.addComponent(new Label("Средняя оценка (double, от 1 до 5):"));
		averageGradeBox = new TextBox(new TerminalSize(20, 1));
		panel.addComponent(averageGradeBox);

		panel.addComponent(new Label("Номер зачетной книжки (String):"));
		recordBookNumberBox = new TextBox(new TerminalSize(30, 1));
		panel.addComponent(recordBookNumberBox);

		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		Panel buttonPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));

		buttonPanel.addComponent(new Button("Далее", this::processCurrentStudent));
		buttonPanel.addComponent(new Button("Отмена", this::close));

		panel.addComponent(buttonPanel);
		setComponent(panel);
	}

	private void processCurrentStudent() {
		try {
			String groupText = groupNumberBox.getText();
			String gradeText = averageGradeBox.getText();
			String recordBookText = recordBookNumberBox.getText();

			if (groupText == null || groupText.trim().isEmpty() ||
					gradeText == null || gradeText.trim().isEmpty() ||
					recordBookText == null || recordBookText.trim().isEmpty()) {
				MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
						"Все поля должны быть заполнены", MessageDialogButton.OK);
				return;
			}

			int groupNumber = Integer.parseInt(groupText.trim());
			double averageGrade = Double.parseDouble(gradeText.trim());
			String recordBookNumber = recordBookText.trim();

			// Валидация данных
			org.teamwork.validation.InputValidator.validateStudent(groupNumber, averageGrade, recordBookNumber);

			Student student = new Student.Builder()
					.groupNumber(groupNumber)
					.averageGrade(averageGrade)
					.recordBookNumber(recordBookNumber)
					.build();

			students.add(student);
			currentIndex++;

			if (currentIndex >= length) {
				// Все студенты введены
				onDataLoaded.accept(students);
				this.close();
			} else {
				// Очищаем поля и обновляем статус
				groupNumberBox.setText("");
				averageGradeBox.setText("");
				recordBookNumberBox.setText("");
				statusLabel.setText(String.format("Введите данные студента %d из %d:", currentIndex + 1, length));

				groupNumberBox.takeFocus();
			}
		} catch (NumberFormatException e) {
			MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
					"Неверный формат данных. Номер группы должен быть целым числом, " +
							"средняя оценка - числом с плавающей точкой.", MessageDialogButton.OK);
		} catch (IllegalArgumentException e) {
			MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка валидации",
					e.getMessage(), MessageDialogButton.OK);
		} catch (Exception e) {
			MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
					"Ошибка: " + e.getMessage(), MessageDialogButton.OK);
		}
	}
}