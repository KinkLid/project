package org.teamwork.sort;


import org.teamwork.model.Student;
import java.util.*;


public abstract class AbstractMergeSort implements StudentSortStrategy {


    protected List<Student> mergeSort(List<Student> list, Comparator<Student> comparator) {
        if (list.size() < 2) return list;


        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));


        mergeSort(left, comparator);
        mergeSort(right, comparator);


        return merge(list, left, right, comparator);
    }


    private List<Student> merge(List<Student> main, List<Student> left, List<Student> right,
                                Comparator<Student> comparator) {
        int i = 0, l = 0, r = 0;


        while (l < left.size() && r < right.size()) {
            if (comparator.compare(left.get(l), right.get(r)) <= 0)
                main.set(i++, left.get(l++));
            else
                main.set(i++, right.get(r++));
        }


        while (l < left.size()) main.set(i++, left.get(l++));
        while (r < right.size()) main.set(i++, right.get(r++));


        return main;
    }


    @Override
    public abstract List<Student> sort(List<Student> students);
}