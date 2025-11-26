package org.teamwork.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;
import org.teamwork.sort.*;

public class SortSelectionWindow extends BasicWindow {
	private final ArrayList<Student> students;
	private final Consumer<List<Student>> onSortComplete;

	public SortSelectionWindow(ArrayList<Student> students, Consumer<List<Student>> onSortComplete) {
		super("Выбор действия");
		this.students = students;
		this.onSortComplete = onSortComplete;

		Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));
		panel.addComponent(new Label("Выберите действие:"));
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 10));

		actionListBox.addItem("1. Обычный способ сортировки", () -> performSort(new ByAllStrategy()));
		actionListBox.addItem("2. Сортировка только чётных групп", () -> performSort(new ByEvenNumberedStrategy()));
		actionListBox.addItem("3. Поиск", this::multiThread);
		actionListBox.addItem("Назад в главное меню", this::close);

		panel.addComponent(actionListBox);
		setComponent(panel);
	}

	private void performSort(StudentSortStrategy strategy) {
		try {
			Student[] studentArray = students.toArray(new Student[0]);
			StudentSort studentSort = new StudentSort(studentArray, strategy);

			Student[] sortedArray = studentSort.getStudents();

			List<Student> sortedList = Arrays.asList(sortedArray);
			onSortComplete.accept(sortedList);
			this.close();

		} catch (Exception e) {
			MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
					"Ошибка при сортировке: " + e.getMessage(), MessageDialogButton.OK);
		}
	}

	private void multiThread() {
		if (students == null || students.isEmpty()) {
			MessageDialog.showMessageDialog(this.getTextGUI(), "Внимание",
					"Список студентов пуст.", MessageDialogButton.OK);
			return;
		}
		getTextGUI().addWindowAndWait(new MultiThreadCounterWindow(this.students));
	}
}
