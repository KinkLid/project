# project
## Описание структуры проекта:

### начальная архитектура
```text
src
    └─java
       └─ app
       └─ model
       └─ sort
       └─ validation
       └─ io
       └─ test
```

### пакеты:
`model` – `Student`, `StudentBuilder`.

`sort` – интерфейс стратегии и реализации сортировок.

`validation` – проверка введённых данных.

`io` – работа с файлами, чтение/запись.

`app` – `Main`, циклы, меню.

`test` – простые тестовые классы.

### выбранный класс:
```text
class Student {
    int groupNumber;
    double averageGrade;
    String recordBookNumber;
}
```


