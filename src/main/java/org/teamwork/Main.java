package org.teamwork;

import java.io.IOException;
import java.util.Collections;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TerminalSize;

import org.teamwork.app.MainWindow;

public class Main {
	void main() {
		Screen screen = null;

		try {
			screen = new DefaultTerminalFactory()
					.setInitialTerminalSize(new TerminalSize(120, 40))
					.createScreen();
			screen.startScreen();

			final MultiWindowTextGUI gui = new MultiWindowTextGUI(screen); // GUI-менеджер
			final MainWindow mainWindow = new MainWindow(); // Главное окно

			mainWindow.setHints(Collections.singletonList(Window.Hint.CENTERED));
			gui.addWindowAndWait(mainWindow);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (screen != null) {
				try {
					screen.stopScreen();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
