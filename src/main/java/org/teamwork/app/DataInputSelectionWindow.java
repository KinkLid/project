package org.teamwork.app;

import java.util.ArrayList;
import java.util.function.Consumer;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.model.Student;

public class DataInputSelectionWindow extends BasicWindow {
	private final Consumer<ArrayList<Student>> onDataLoaded;

	public DataInputSelectionWindow(Consumer<ArrayList<Student>> onDataLoaded) {
		super("Выбор способа заполнения данных");
		this.onDataLoaded = onDataLoaded;

		Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));
		panel.addComponent(new Label("Выберите способ заполнения массива данных:"));
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 10));

		actionListBox.addItem("1. Загрузка из файла", () -> {
			FileInputWindow fileWindow = new FileInputWindow(onDataLoaded);
			this.getTextGUI().addWindow(fileWindow);
		});

		actionListBox.addItem("2. Случайная генерация", () -> {
			LengthInputWindow lengthWindow = new LengthInputWindow("Введите длину массива для случайной генерации:",
					length -> {
						try {
							org.teamwork.io.StudentInputHandler handler = new org.teamwork.io.StudentInputHandler();
							ArrayList<Student> students = handler.getRandomInput(length);
							onDataLoaded.accept(students);
							this.close();
						} catch (Exception e) {
							showError("Ошибка при генерации данных: " + e.getMessage());
						}
					});
			this.getTextGUI().addWindow(lengthWindow);
		});

		actionListBox.addItem("3. Ввод вручную", () -> {
			LengthInputWindow lengthWindow = new LengthInputWindow("Введите длину массива для ручного ввода:",
					length -> {
						ManualInputWindow manualWindow = new ManualInputWindow(length, onDataLoaded);
						this.getTextGUI().addWindow(manualWindow);
						this.close();
					});
			this.getTextGUI().addWindow(lengthWindow);
		});

		actionListBox.addItem("Назад в главное меню", this::close);

		panel.addComponent(actionListBox);
		setComponent(panel);
	}

	private void showError(String message) {
		MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка", message,
				MessageDialogButton.OK);
	}
}
