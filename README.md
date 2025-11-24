# project

## Описание структуры проекта:

### Начальная архитектура:
```
src
└── main
	└── java
		└── org
			└── teamwork
				├── app
				├── io
				├── model
				├── sort
				├── test
				├── validation
				└── Main.java
```

### Пакеты:
- `app` — циклы, меню.
- `io` — работа с файлами, чтение/запись.
- `model` — `Student`, `StudentBuilder`.
- `sort` — интерфейс стратегии и реализации сортировок.
- `test` — простые тестовые классы.
- `validation` — проверка введённых данных.

### Выбранный класс:
```java
class Student {
	int groupNumber;
	double averageGrade;
	String recordBookNumber;
}
```