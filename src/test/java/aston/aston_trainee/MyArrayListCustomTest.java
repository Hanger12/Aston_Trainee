package aston.aston_trainee;

import aston.aston_trainee.CustomArrayList.Class.MyArrayListCustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyArrayListCustomTest {
    MyArrayListCustom<String> myArrayListCustom = new MyArrayListCustom<>();
    @BeforeEach
    void init() {
        myArrayListCustom.add("InitOne12");
        myArrayListCustom.add("InitTwo12");
        myArrayListCustom.add("InitFree12");
    }
    @Test
    void add() {
        myArrayListCustom.add("One12");
        assertEquals(myArrayListCustom.get(myArrayListCustom.getSize()-1),"One12");
    }
    @Test
    void addByIndex() {
        myArrayListCustom.add(0,"One12");
        myArrayListCustom.add(1,"two12");
        myArrayListCustom.add(2,"free12");
        myArrayListCustom.add(3,"four12");
        assertEquals(myArrayListCustom.get(3),"four12");
    }
    @Test
    void get() {
        int index = 2;
        assertEquals(index,2);
        assertEquals(myArrayListCustom.get(index),"InitFree12");
    }
    @Test
    void addAll() {
        myArrayListCustom.addAll(List.of("OtherOne","OtherTwo","OtherFree","OtherFour"));
        assertEquals(myArrayListCustom.get(myArrayListCustom.getSize()-1),"OtherFour");
    }
    @Test
    void removeByIndex () {
        assertEquals(myArrayListCustom.get(1),"InitTwo12");
        myArrayListCustom.remove(1);
        assertEquals(myArrayListCustom.get(1),"InitFree12");
    }
    @Test
    void removeByObject () {
        assertEquals(myArrayListCustom.get(1),"InitTwo12");
        myArrayListCustom.remove("InitTwo12");
        assertEquals(myArrayListCustom.get(1),"InitFree12");
    }
    @Test
    void clear() {
        myArrayListCustom.clear();
        assertTrue(myArrayListCustom.isEmpty());
    }
}
