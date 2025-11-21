package main.sort;
import main.model.Student   ;
import java.util.Comparator;

public class ByRecordBookNumberStrategy implements StudentSortStrategy  {
    private Student[] mergeSort(Student[] main){

        if (main.length < 2) return main; //пока элемент не станет одиночным делим

        int mid = main.length / 2;

        Comparator<String> comp = String::compareTo; //компаратор для сравнения строк

        Student[] left = new Student[mid];
        Student[] right = new Student[main.length - mid];

        System.arraycopy(main, 0, left, 0, mid);
        System.arraycopy(main, mid, right, 0, right.length);

        mergeSort(left);
        mergeSort(right);

        int l = 0, r = 0, m = 0;
        while (l < left.length && r < right.length) { //будет выполняться пока один из массивов не дойдет до конца
            if(left[l].getGroupNumber() < right[r].getGroupNumber()){
                main[m++] = left[l++];
                continue;
            }

            if(left[l].getGroupNumber() > right[r].getGroupNumber()){
                main[m++] = right[r++];
                continue;
            }

            if (left[l].getAverageGrade() < right[r].getAverageGrade()){
                main[m++] = left[l++];
                continue;
            }

            if (left[l].getAverageGrade() > right[r].getAverageGrade()){
                main[m++] = right[r++];
                continue;
            }

            if (comp.compare(left[l].getRecordBookNumber(),right[r].getRecordBookNumber()) <= 0)
                main[m++] = left[l++];
            else
                main[m++] = right[r++];

        }

        while (l < left.length) // сливаем остатки левого массива
            main[m++] = left[l++];

        while (r < right.length) // сливаем остатки правого массива
            main[m++] = right[r++];
        return main;

    }

    @Override
    public Student[] sort(Student[] students) {
        if(students == null) return null;
        students = mergeSort(students);
        return students;
    }
}
