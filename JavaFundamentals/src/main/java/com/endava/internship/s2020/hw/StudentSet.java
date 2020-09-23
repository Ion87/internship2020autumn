package com.endava.internship.s2020.hw;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class StudentSet implements Set<Student> {
    @Override
    public int size() {
        //TODO
        return 0;
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return false;
    }

    @Override
    public boolean contains(Object o) {
        //TODO
        return false;
    }

    @Override
    public Iterator<Student> iterator() {
        //TODO
        return null;
    }

    @Override
    public Object[] toArray() {
        //TODO
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Student student) {
        //TODO
        return false;
    }

    @Override
    public boolean remove(Object o) {
        //TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        //TODO
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        //TODO
    }
}
