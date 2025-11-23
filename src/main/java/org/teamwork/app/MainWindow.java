package org.teamwork.app;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.TerminalSize;

public class MainWindow extends BasicWindow {
	public MainWindow() {
		super("Главное меню");

		Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));

		mainPanel.addComponent(new Label("«Cортируем студентов»"));
		mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 20)); // Меню и размеры окон

		// Запускаем цикл работы приложения
		actionListBox.addItem("Начать работу приложения", this::startWorkCycle);

		actionListBox.addItem("Выход", this::close);

		mainPanel.addComponent(actionListBox);
		setComponent(mainPanel);
	}

	private void startWorkCycle() {
		// Окно выбора способа ввода данных
		DataInputSelectionWindow dataInputWindow = new DataInputSelectionWindow(students -> {
			// После загрузки данных показываем окно выбора сортировки
			SortSelectionWindow sortWindow = new SortSelectionWindow(students, sortedStudents -> {
				// После сортировки показываем результаты
				ResultWindow resultWindow = new ResultWindow(sortedStudents);
				resultWindow.setHints(java.util.Collections.singletonList(Window.Hint.CENTERED));
				this.getTextGUI().addWindow(resultWindow);
			});
			sortWindow.setHints(java.util.Collections.singletonList(Window.Hint.CENTERED));
			this.getTextGUI().addWindow(sortWindow);
		});
		dataInputWindow.setHints(java.util.Collections.singletonList(Window.Hint.CENTERED));
		this.getTextGUI().addWindow(dataInputWindow);
	}
}
