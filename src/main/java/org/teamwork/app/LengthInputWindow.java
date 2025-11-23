package org.teamwork.app;

import java.util.function.Consumer;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.TerminalSize;

public class LengthInputWindow extends BasicWindow {
	public LengthInputWindow(String prompt, Consumer<Integer> onLengthEntered) {
		super("Ввод длины массива");

		Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));
		panel.addComponent(new Label(prompt));
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		TextBox lengthTextBox = new TextBox(new TerminalSize(20, 1));
		panel.addComponent(lengthTextBox);
		panel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

		Panel buttonPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));

		buttonPanel.addComponent(new Button("OK", () -> {
			try {
				String text = lengthTextBox.getText();
				if (text == null || text.trim().isEmpty()) {
					MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
							"Пожалуйста, введите длину массива", MessageDialogButton.OK);
					return;
				}

				int length = Integer.parseInt(text.trim());
				if (length <= 0) {
					MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
							"Длина массива должна быть положительным числом", MessageDialogButton.OK);
					return;
				}

				onLengthEntered.accept(length);
				this.close();
			} catch (NumberFormatException e) {
				MessageDialog.showMessageDialog(this.getTextGUI(), "Ошибка",
						"Неверный формат числа. Пожалуйста, введите целое число.", MessageDialogButton.OK);
			}
		}));

		buttonPanel.addComponent(new Button("Отмена", this::close));

		panel.addComponent(buttonPanel);
		setComponent(panel);
	}
}
