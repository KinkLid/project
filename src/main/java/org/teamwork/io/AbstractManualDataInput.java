package org.teamwork.io;

import java.util.ArrayList;
import java.util.Scanner;

// Абстрактный класс для ручного ввода данных.
public abstract class AbstractManualDataInput<T> {
	// Статический сканер для ввода данных пользователем
	protected static final Scanner scanner = new Scanner(System.in);

	// Абстрактный метод для создания объекта типа T
	protected abstract T createObject();

	// Метод для ручного ввода пользователем массива объектов типа T
	// Метод позволяет создать и заполнить список объектов с помощью метода createObject()

	public ArrayList<T> manualDataInputArray(int length) {
		ArrayList<T> items = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			IO.println("Элемент номер: " + i);
			items.add(createObject()); // Вызываем реализацию из наследника
		}

		return items;
	}
}
