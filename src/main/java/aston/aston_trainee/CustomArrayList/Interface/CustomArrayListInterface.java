package aston.aston_trainee.CustomArrayList.Interface;

import java.util.Collection;
import java.util.Comparator;

public interface CustomArrayListInterface<E> {
    void add(E element);
    void add(int index, E element);
    void addAll(Collection<? extends E> collection);
    void clear();
    E get(int index);
    E remove(int index);
    boolean isEmpty();
    void remove(Object object);
    void sort(Comparator<? super E> c);
    void trimToSize();
}
