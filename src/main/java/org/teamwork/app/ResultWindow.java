package org.teamwork.app;

import java.util.List;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;

public class ResultWindow extends BasicWindow {
	public ResultWindow(List<Student> students) {
		super("Результат сортировки");

		Panel panel = new Panel(new GridLayout(1)); // Посмотри на колонки после реализации

		Table<String> table = new Table<>("Номер группы", "Средний балл", "Номер зачётки");

		for (Student student : students) {
			table.getTableModel().addRow(
					String.format("%d", student.getGroupNumber()),
					String.format("%.2f", student.getAverageGrade()),
					student.getRecordBookNumber()
			);
		}

		panel.addComponent(table.withBorder(Borders.singleLine())); // Это интерактивные компоненты
		panel.addComponent(new EmptySpace());
		Panel buttonPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));
		buttonPanel.addComponent(new Button("OK", this::close));
		buttonPanel.addComponent(new EmptySpace(new TerminalSize(1, 0)));
		// Закрываем это окно, возвращаемся в главное меню (которое остается открытым)
		buttonPanel.addComponent(new Button("Вернуться в главное меню", this::close));

		panel.addComponent(buttonPanel);

		setComponent(panel);
	}
}
