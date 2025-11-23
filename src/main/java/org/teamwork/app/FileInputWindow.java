package org.teamwork.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;

public class FileInputWindow extends BasicWindow {
	private final Consumer<ArrayList<Student>> onDataLoaded;

	public FileInputWindow(Consumer<ArrayList<Student>> onDataLoaded) {
		super("Загрузка из файла");
		this.onDataLoaded = onDataLoaded;

		Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));
		panel.addComponent(new Label("Введите имя файла (без расширения .txt):"));
		panel.addComponent(new Label("Файл должен находиться в: src/test/resources/"));
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		TextBox fileNameTextBox = new TextBox(new TerminalSize(30, 1));
		panel.addComponent(fileNameTextBox);
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		Panel buttonPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));

		buttonPanel.addComponent(new Button("Загрузить", () -> {
			try {
				String fileName = fileNameTextBox.getText();
				if (fileName == null || fileName.trim().isEmpty()) {
					MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
							"Пожалуйста, введите имя файла", MessageDialogButton.OK);
					return;
				}

				String filePath = "src/test/resources/" + fileName.trim() + ".txt";
				org.teamwork.io.StudentInputHandler handler = new org.teamwork.io.StudentInputHandler();
				ArrayList<Student> students = handler.getFileInput(filePath);

				if (students.isEmpty()) {
					MessageDialog.showMessageDialog(this.getTextGUI(), "Предупреждение",
							"Файл пуст или не содержит корректных данных", MessageDialogButton.OK);
				} else {
					onDataLoaded.accept(students);
					this.close();
				}
			} catch (IOException e) {
				MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
						"Ошибка при чтении файла: " + e.getMessage(), MessageDialogButton.OK);
			} catch (Exception e) {
				MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
						"Ошибка: " + e.getMessage(), MessageDialogButton.OK);
			}
		}));

		buttonPanel.addComponent(new Button("Отмена", this::close));

		panel.addComponent(buttonPanel);
		setComponent(panel);
	}
}
