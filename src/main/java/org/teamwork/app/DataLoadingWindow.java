package org.teamwork.app;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.TerminalSize;

public class DataLoadingWindow extends BasicWindow {
    public DataLoadingWindow() {
        super("Выберите способ заполнения данных");

        Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));

        ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 20));

        // TODO
    }
}