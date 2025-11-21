package org.teamwork.app;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;

//import org.teamwork.model.Student; // Потом нужно проверить

import java.util.List;


public class MainWindow extends BasicWindow {

    public MainWindow() {
        super("Главное меню");

        Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));

        mainPanel.addComponent(new Label("«Cортируем студентов»")); // Заголовок окна
        mainPanel.addComponent(new EmptySpace(new TerminalSize(0, 1)));

        ActionListBox actionListBox = new ActionListBox(new TerminalSize(60, 20)); // Меню и размеры окон

        actionListBox.addItem("Начать работу приложения", () -> { // Начинаем работку, после нажатия откроются другие окна
            DataLoadingWindow dataLoadingWindow = new DataLoadingWindow(); // Окно выбора источника данных
            this.getTextGUI().addWindow(dataLoadingWindow); // Метод Лантерны, который даёт доступ GUI-менеджеру из текущего окна
        });

        actionListBox.addItem("Выход", this::close); // Метод Лантерны для закрытия

        mainPanel.addComponent(actionListBox);
        setComponent(mainPanel);
    }
}