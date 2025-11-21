package org.teamwork.app;

import java.util.List;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.table.Table;

import org.teamwork.model.Student;

public class ResultWindow extends BasicWindow {
    public ResultWindow(List<Student> students) {
        super("Результат сортировки");

        Panel panel = new Panel(new GridLayout(3)); // Посмотри на колонки после реализации

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
        panel.addComponent(new Button("OK", this::close).setLayoutData(
                GridLayout.createHorizontallyFilledLayoutData()));

        setComponent(panel);
    }
}