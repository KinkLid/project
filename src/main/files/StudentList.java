package org.teamwork.collections;


import org.teamwork.model.Student;
import java.util.*;


public class StudentList implements List<Student> {
    private final List<Student> inner = new ArrayList<>();
    @Override public int size() { return inner.size(); }
    @Override public boolean isEmpty() { return inner.isEmpty(); }
    @Override public boolean add(Student student) { return inner.add(student); }
    @Override public Student get(int index) { return inner.get(index); }
    @Override public Student remove(int index) { return inner.remove(index); }
    @Override public Iterator<Student> iterator() { return inner.iterator(); }
    @Override public boolean addAll(Collection<? extends Student> c) { return inner.addAll(c); }
    @Override public boolean contains(Object o) { throw new UnsupportedOperationException(); }
    @Override public Object[] toArray() { throw new UnsupportedOperationException(); }
    @Override public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }
    @Override public boolean remove(Object o) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(int index, Collection<? extends Student> c){ throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public void clear() { throw new UnsupportedOperationException(); }
    @Override public Student set(int index, Student element){ throw new UnsupportedOperationException(); }
    @Override public void add(int index, Student element){ throw new UnsupportedOperationException(); }
    @Override public int indexOf(Object o){ throw new UnsupportedOperationException(); }
    @Override public int lastIndexOf(Object o){ throw new UnsupportedOperationException(); }
    @Override public ListIterator<Student> listIterator(){ throw new UnsupportedOperationException(); }
    @Override public ListIterator<Student> listIterator(int index){ throw new UnsupportedOperationException(); }
    @Override public List<Student> subList(int fromIndex, int toIndex){ throw new UnsupportedOperationException(); }
}