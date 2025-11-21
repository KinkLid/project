package main.io;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractRandomDataInput <T> {

    protected static final Random random = new Random();

    //  Метод для создания случайного объекта

    protected abstract T createRandomObject();

    // Метод для создания списка случайных объектов заданной длины.
    public ArrayList<T> createRandomInputArray(int length) {
        ArrayList<T> items = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            items.add(createRandomObject());
        }
        return items;
    }
}
