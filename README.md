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
- `model` — `Student`, `StudentBuilder`.
- `sort` — интерфейс стратегии и реализации сортировок.
- `validation` — проверка введённых данных.
- `io` — работа с файлами, чтение/запись.
- `app` — `Main`, циклы, меню.
- `test` — простые тестовые классы.

### Выбранный класс:
```java
class Student {
    int groupNumber;
    double averageGrade;
    String recordBookNumber;
}
```
