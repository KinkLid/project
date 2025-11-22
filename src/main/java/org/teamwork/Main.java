package org.teamwork;

import java.io.IOException;
import java.util.Collections;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import org.teamwork.app.MainWindow;

public class Main {
    static void main() {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = null;
        Screen screen = null;

        try {
            terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();

            final MultiWindowTextGUI gui = new MultiWindowTextGUI(screen); // GUI-менеджер

            MainWindow mainWindow = new MainWindow(); // Главное окно
            mainWindow.setHints(Collections.singletonList(Window.Hint.CENTERED)); // Тут оно запускается

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