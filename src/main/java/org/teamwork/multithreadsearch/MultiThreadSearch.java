package org.teamwork.multithreadsearch;

import org.teamwork.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadSearch {
	public static int countStudentOccurrences(List<Student> students, Student target, int numberOfThreads) throws InterruptedException {
		// Проверка на пустоту
		if (students == null || students.isEmpty()) {
			System.out.println("Коллекция студентов пуста.");
			return 0;
		}

		int listSize = students.size();

		// Корректировка количества потоков
		if (numberOfThreads <= 0) numberOfThreads = 1;
		if (numberOfThreads > listSize) numberOfThreads = listSize;

		AtomicInteger totalCount = new AtomicInteger(0);
		List<Thread> threads = new ArrayList<>();
		int chunkSize = listSize / numberOfThreads;

		// Создание и запуск потоков
		for (int i = 0; i < numberOfThreads; i++) {
			final int start = i * chunkSize;
			final int end = (i == numberOfThreads - 1) ? listSize : (i + 1) * chunkSize;

			Thread t = new Thread(() -> {
				int localCount = 0;
				for (int j = start; j < end; j++) {
					// Сравниваем текущего студента с искомым (target)
					if (students.get(j).equals(target)) {
						localCount++;
					}
				}
				totalCount.addAndGet(localCount);
			});

			threads.add(t);
			t.start();
		}

		// Ожидание завершения всех потоков
		for (Thread t : threads) {
			t.join();
		}

		int result = totalCount.get();

		// Вывод результата в консоль
		System.out.println("Поиск завершен. Искали: " + target);
		System.out.println("Найдено вхождений: " + result);

		return result;
	}
}
