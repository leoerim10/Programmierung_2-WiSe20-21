import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MeinArrayTest {
    private MeinArray ma;

    @Before
    public void initMeinArray(){
        ma = new MeinArray();
    }


    @Test
    public void testArraysNotEqual(){ //check if two different arrays are shown as unequal
        float[] array1  = {1.0f, 2.0f, 3.0f};
        float[] array2 = {1.0f, 2.0f, 4.0f};

        assertTrue(ma.istGleich(array1, array2) == false);
    }

    @Test
    public void testArrayDifferentLength(){ // check if two arrays of different length are unequal
        float[] array1  = {1.0f, 2.0f, 3.0f};
        float[] array2 = {1.0f, 2.0f};
        assertTrue(ma.istGleich(array1, array2) == false);
    }


    @Test
    public void testArrayEqual(){ // two same float arrays (best case)
        float[] array1 = {1.0f, 2.0f, 3.0f};
        float[] array2 = {1.0f, 2.0f, 3.0f};

        // istGleich() should return true
        assertTrue(ma.istGleich(array1, array2) == true);
    }

    @Test
    public void testEmptyArray() { // check when one of the array is empty
        float[] array1 = {1.0f, 2.0f, 3.0f};
        float[] array2 = {};

        assertTrue(ma.istGleich(array1, array2) == false);
    }

    @Test
    public void testExistingElement() {// check the already existing element in the sorted array
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double elem = 4.0;

        assertTrue(ma.sucheElem(elem, array) == 3);
    }

    @Test
    public void testNotExistingElement() { // check the element that is not in sorted array and when not return -1
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double elem = 5.0;

        assertTrue(ma.sucheElem(elem, array) == -1);
    }

    @Test
    public void testExistingElement1() {// check the already existing element in the unsorted array and make sure it returns the index after it get sorted

        double[] array = {2.1, 3.0, 4.0, 6.9, 3.0, 2.2, 4.1, 6.0, 5.3, 3.1, 6.6};
        double elem = 2.1;

        assertTrue(ma.sucheElem(elem, array) == 0);
    }

    @Test
    public void testNotExistingElement2() { // check the element that is not in unsorted array and when not return -1

        double[] array = {2.1, 3.0, 4.0, 6.9, 3.0, 2.2, 4.1, 6.0, 5.3, 3.1, 6.6};
        double elem = 9.9;

        assertEquals(ma.sucheElem(elem, array) ,-1);
    }

    @Test
    public void testEinfuegeSortiert1() {
        // array already sorted, element in array
        int[] array = {1, 2, 3, 4};
        int elem = 4;

        assertArrayEquals(ma.einfuegeSortiert(array, elem), array);
    }


    @Test
    public void testEinfuegeSortiert2() {
        // add an element to already sorted array
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5, 9};
        int elem = 9;

        assertArrayEquals(ma.einfuegeSortiert(array, elem), array2);
    }


    @Test
    public void testEinfuegeSortiert3() {
        // add an already existing element to a unsorted array, verify element is added and array is sorted.
        int[] array = {3,5,1,8};
        int elem = 3;
        int[] expected = {1,3,5,8};

        assertArrayEquals(ma.einfuegeSortiert(array, elem), expected);
    }
    @Test
    public void addExistingElement(){
        // add a new element to unsorted array, make sure array is sorted in the end.
        int[] array = {3,5,1,8};
        int elem = 4;
        int[] expected = {1,3,4,5,8};
        assertArrayEquals(ma.einfuegeSortiert(array, elem), expected);
    }


}