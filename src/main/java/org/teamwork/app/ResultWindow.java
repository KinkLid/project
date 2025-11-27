package org.teamwork.app;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialog;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;
import org.teamwork.io.SaveInFile;

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

        buttonPanel.addComponent(new Button("Сохранить в файл", () -> {
            saveListToFile(students);
        }));
        buttonPanel.addComponent(new EmptySpace(new TerminalSize(1, 0)));

        // Закрываем это окно, возвращаемся в главное меню (которое остается открытым)
		buttonPanel.addComponent(new Button("Вернуться в главное меню", this::close));

		panel.addComponent(buttonPanel);

		setComponent(panel);
	}

    private void saveListToFile(List<Student> students) {
        String fileName = TextInputDialog.showDialog(getTextGUI(), "Сохранение", "Введите имя файла (напр. result.txt):", "result.txt");
        if (fileName != null && !fileName.trim().isEmpty()) { // Если пользователь нажал Cancel, fileName будет null
            try {
                ArrayList<Student> listToSave = new ArrayList<>(students);

                SaveInFile.save(fileName, listToSave);

                MessageDialog.showMessageDialog(getTextGUI(), "Успех", "Данные успешно сохранены в " + fileName, MessageDialogButton.OK);
            } catch (IOException e) {
                MessageDialog.showMessageDialog(getTextGUI(), "Ошибка", "Не удалось записать файл:\n" + e.getMessage(), MessageDialogButton.OK);
            }
        }
    }
}
