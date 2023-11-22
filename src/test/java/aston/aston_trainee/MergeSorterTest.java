//package aston.aston_trainee;
//
//import aston.aston_trainee.CustomArrayList.Class.MergeSorter;
//import aston.aston_trainee.CustomArrayList.Interface.SortingAlgorithms;
//import org.junit.jupiter.api.Test;
//
//import java.util.Comparator;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//
//public class MergeSorterTest {
//    SortingAlgorithms<Object> sortingAlgorithms = new MergeSorter<>();
//
//    @Test
//    void MergeSorterInteger() {
//        Integer[] ElementData = {56,14,34,23,67,99,78};
//        sortingAlgorithms.sort(Comparator.naturalOrder(),ElementData);
//        Integer[] NewElementData = {56,14,34,23,67,99,78};
//        sortingAlgorithms.sort(Comparator.naturalOrder(),NewElementData);
//        assertArrayEquals(ElementData, NewElementData);
//    }
//    @Test
//    void MergeSorterString() {
//        String[] ElementData = {"One56","two14","free34","five23","six67","nine99","ten78"};
//        sortingAlgorithms.sort(Comparator.naturalOrder(),ElementData);
//        String[] NewElementData = {"One56","two14","free34","five23","six67","nine99","ten78"};
//        sortingAlgorithms.sort(Comparator.naturalOrder(),NewElementData);
//        assertArrayEquals(ElementData, NewElementData);
//    }
//}
