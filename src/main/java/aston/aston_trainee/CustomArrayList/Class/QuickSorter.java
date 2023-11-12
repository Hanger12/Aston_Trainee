package aston.aston_trainee.CustomArrayList.Class;

import aston.aston_trainee.CustomArrayList.Interface.SortingAlgorithms;

import java.util.Comparator;

public class QuickSorter<E> implements SortingAlgorithms<E> {
    public <E> void quickSort(E[] array, int low, int high,Comparator<? super E> c) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        E opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (c.compare(array[i],opora)<0) {
                i++;
            }

            while (c.compare(array[j],opora)>0) {
                j--;
            }

            if (i <= j) {//меняем местами
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j,c);

        if (high > i)
            quickSort(array, i, high,c);
    }

    @Override
    public <E> void sort(Comparator<? super E> c, E[] elementData) {
        quickSort(elementData,0,elementData.length - 1,c);
    }
}
