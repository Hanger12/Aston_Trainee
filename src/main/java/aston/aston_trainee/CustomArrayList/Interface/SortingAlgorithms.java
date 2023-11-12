package aston.aston_trainee.CustomArrayList.Interface;

import java.util.Comparator;

public interface SortingAlgorithms<E> {
   <E> void sort(Comparator<? super E> c, E[] elementData );
}
