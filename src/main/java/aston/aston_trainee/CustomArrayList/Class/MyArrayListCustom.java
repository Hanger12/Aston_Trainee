package aston.aston_trainee.CustomArrayList.Class;

import aston.aston_trainee.CustomArrayList.Interface.CustomArrayListInterface;
import aston.aston_trainee.CustomArrayList.Interface.SortingAlgorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayListCustom<E> implements CustomArrayListInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private Object[] elementData;
    int size = 0;

    public MyArrayListCustom() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    public MyArrayListCustom(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public void add(E element) {
       add(getSize(),element);
    }

    @Override
    public void add(int index, E element) {
        if (index >= elementData.length) {
            rangeCheckOfBoundsException(index);
            elementData = growArray(index+1);
            elementData[index] = element;
            size = elementData.length;
            //System.out.println(size);
        }
        else {
            elementData[index] = element;
            size++;
        }
    }
    @Override
    public void addAll(Collection<? extends E> collection) {
        for(E object : collection) {
            add(size,object);
        }

    }
    private Object[] growArray(int newCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0) {
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, newCapacity)];
        }
    }
    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
        {
            es[i] = null;
        }
    }

    @Override
    public E get(int index) {
        rangeCheckOfBoundsException(index);
        return (E) elementData[index];
    }

    @Override
    public E remove(int index) {
        rangeCheckOfBoundsException(index);
        final Object[] es = elementData;
        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);
        return oldValue;
    }
    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(Object object) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        if (object == null) {
            for (; i < size; i++)
                if (es[i] == null)
                    break;
        } else {
            for (; i < size; i++)
                if (object.equals(es[i]))
                    break;
        }
        fastRemove(es, i);
    }

    @Override
    public void sort(Comparator<? super E> c) {
//        SortingAlgorithms<E> sortingAlgorithms = new MergeSorter<>();
//        sortingAlgorithms.sort(c,(E[]) elementData);
        trimToSize();
        SortingAlgorithms<E> sortingAlgorithms = new QuickSorter<>();
        sortingAlgorithms.sort(c,(E[]) elementData);
    }

    @Override
    public void trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }


    private void rangeCheckOfBoundsException(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+ " , Size: "+size;
    }
}
