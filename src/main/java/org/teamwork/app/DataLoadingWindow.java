package org.teamwork.app;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

public class DataLoadingWindow extends BasicWindow {
    public DataLoadingWindow() {
        super("Выберите способ заполнения данных");

        Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));

        ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 20));

        // I have no idea, что мне пока что тут делать (импорты потом приклею)
    }

}