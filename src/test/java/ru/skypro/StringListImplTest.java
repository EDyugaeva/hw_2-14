package ru.skypro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.skypro.exceptions.EmptyListException;
import ru.skypro.exceptions.EmptyParameterException;
import ru.skypro.exceptions.MissingElementException;
import ru.skypro.exceptions.MissingNumberException;

import static ru.skypro.StringListConstans.*;

public class StringListImplTest {
    private final StringListImpl out = new StringListImpl();

    @Test
    public void testAddSmth() {
        Assertions.assertEquals(FIRST, out.add(FIRST));
        Assertions.assertEquals(1, out.size);
        Assertions.assertEquals(FIRST, out.get(0));
    }

    @Test
    public void testExceptionWhenAddingNullElement() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.add(""));
    }

    @Test
    public void testAddSmthIndex() {
        Assertions.assertEquals(FIRST, out.add(3, FIRST));
        Assertions.assertEquals(SECOND, out.add(6, SECOND));
        Assertions.assertEquals(FIRST, out.get(0));
        Assertions.assertEquals(SECOND, out.get(1));
        Assertions.assertEquals(2, out.size);
    }

    @Test
    public void testExceptionWhenAddingNullElementWithIndex() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.add(4, ""));
        Assertions.assertThrows(EmptyParameterException.class, () -> out.add(-1, FIRST));
    }

    @Test
    public void testSetSmthInIndex() {
        out.add(FIRST);
        out.add(SECOND);
        out.add(THIRD);
        Assertions.assertEquals(OTHER, out.set(0, OTHER));
        Assertions.assertEquals(OTHER2, out.set(1, OTHER2));
        Assertions.assertEquals(OTHER, out.get(0));
        Assertions.assertEquals(OTHER2, out.get(1));
        Assertions.assertEquals(THIRD, out.get(2));
        Assertions.assertEquals(3, out.size);
    }

    @Test
    public void testExceptionWhenSettingNullElementWithIndex() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.set(1, ""));
        Assertions.assertThrows(EmptyParameterException.class, () -> out.set(-1, FIRST));
    }

    @Test
    public void testRemoveItem() {
        out.add(FIRST);
        Assertions.assertEquals(FIRST, out.remove(FIRST));
        Assertions.assertEquals(0, out.size);

    }

    @Test
    public void testExceptionWhenRemovingNullElement() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.remove(""));
    }

    @Test
    public void testExceptionWhenRemovingMissingElement() {
        Assertions.assertThrows(MissingElementException.class, () -> out.remove(OTHER));
    }

    @Test
    public void testRemoveIndex() {
        out.add(FIRST);
        Assertions.assertEquals(FIRST, out.remove(0));
        Assertions.assertEquals(0, out.size);

    }

    @Test
    public void testExceptionWhenRemovingWrongIndex() {
        out.add(FIRST);
        Assertions.assertThrows(EmptyParameterException.class, () -> out.remove(-1));
        Assertions.assertThrows(EmptyParameterException.class, () -> out.remove(1));

    }

    @Test
    public void testContainElement() {
        out.add(FIRST);
        Assertions.assertTrue(out.contains(FIRST));
        Assertions.assertFalse(out.contains(OTHER));

    }

    @Test
    public void testExceptionWhenFindEmptyElement() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.contains(""));

    }

    @Test
    public void testIndexOf() {
        out.add(FIRST);
        out.add(SECOND);
        Assertions.assertEquals(0, out.indexOf(FIRST));
        Assertions.assertEquals(1, out.indexOf(SECOND));
        Assertions.assertEquals(-1, out.indexOf(OTHER));
    }

    @Test
    public void testIndexOfExceptionWrongItem() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.indexOf(""));

    }

    @Test
    public void testLastIndexOf() {
        out.add(FIRST);
        out.add(SECOND);
        Assertions.assertEquals(0, out.lastIndexOf(FIRST));
        Assertions.assertEquals(1, out.lastIndexOf(SECOND));
        Assertions.assertEquals(-1, out.lastIndexOf(OTHER));
    }

    @Test
    public void testLastIndexOfExceptionWrongItem() {
        Assertions.assertThrows(EmptyParameterException.class, () -> out.lastIndexOf(""));

    }

    @Test
    public void testGet() {
        out.add(FIRST);
        out.add(SECOND);
        Assertions.assertEquals(FIRST, out.get(0));
        Assertions.assertEquals(SECOND, out.get(1));

    }

    @Test
    public void testGetExceptions() {
        out.add(FIRST);
        Assertions.assertThrows(EmptyParameterException.class, () -> out.get(-1));
        Assertions.assertThrows(MissingNumberException.class, () -> out.get(1));

    }

    @Test
    public void testEquals() {
        out.add(FIRST);
        out.add(SECOND);

        StringList list = new StringListImpl();
        list.add(FIRST);
        list.add(SECOND);

        StringList list2 = new StringListImpl();
        list2.add(FIRST);

        Assertions.assertTrue(out.equals(list));
        Assertions.assertFalse(out.equals(list2));

    }

    @Test
    public void testEqualsExceptions() {
        StringList list1 = new StringListImpl();
        Assertions.assertThrows(EmptyListException.class, () -> out.equals(list1));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, out.size);
        out.add(FIRST);
        Assertions.assertEquals(1, out.size);
        out.add(SECOND);
        Assertions.assertEquals(2, out.size);
        out.add(THIRD);
        Assertions.assertEquals(3, out.size);
    }


    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(out.isEmpty());
        out.add(FIRST);
        Assertions.assertFalse(out.isEmpty());
    }

    @Test
    public void testClear() {
        out.add(FIRST);
        Assertions.assertFalse(out.isEmpty());
        out.clear();
        Assertions.assertTrue(out.isEmpty());
    }

    @Test
    public void testToArray() {
        out.add(FIRST);
        Assertions.assertEquals(1,out.size);
        String[] testArray = new String[2];
        testArray[0]=OTHER;
        testArray[1]=OTHER2;
        Assertions.assertEquals(testArray, out.toArray(testArray));
        Assertions.assertEquals(2, out.size);


    }

    @Test
    public void testToArrayExceptions() {
        String[] testArray = new String[2];
        testArray[0] = "";
        testArray[1]="";
        Assertions.assertThrows(EmptyParameterException.class, () -> out.toArray(testArray));

    }



}
