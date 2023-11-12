package aston.aston_trainee.CustomArrayList.Class;

import aston.aston_trainee.CustomArrayList.Interface.SortingAlgorithms;

import java.util.Comparator;

public class MergeSorter<E> implements SortingAlgorithms<E> {
    public static <E> void mergeSort(E[] source, int left, int right,Comparator<? super E> comparator) {
        int delimiter = (right + left) / 2;
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter-1,comparator);
            mergeSort(source, delimiter, right,comparator);
        }
        Object[] buffer = new Object[right - left + 1];
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            if (delimiter > right || comparator.compare(source[cursor], source[delimiter])<0) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    }

    @Override
    public <E> void sort(Comparator<? super E> c, E[] elementData) {
        mergeSort(elementData,0,elementData.length-1,c);
    }
}
