package adt.heap.extended;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;

public class FloorCeilTest {
    
    FloorCeilHeap maxHeap;
    FloorCeilHeap minHeap;

    @Before
    public void setUp(){
        maxHeap = new FloorCeilHeapImpl(new ComparatorMaxHeap<Integer>());
        minHeap = new FloorCeilHeapImpl(new ComparatorMinHeap<Integer>());
    }

    @Test
    public void test01(){
        Integer[] array = new Integer[]{2, 4, 6, 8 ,10, 12};

        Assert.assertTrue(maxHeap.floor(array, 0) == null);
        Assert.assertTrue(maxHeap.floor(array, 1) == null);
        Assert.assertTrue(maxHeap.floor(array, 2) == 2);
        Assert.assertTrue(maxHeap.floor(array, 3) == 2);
        Assert.assertTrue(maxHeap.floor(array, 4) == 4);
        Assert.assertTrue(maxHeap.floor(array, 5) == 4);
        Assert.assertTrue(maxHeap.floor(array, 6) == 6);
        Assert.assertTrue(maxHeap.floor(array, 7) == 6);
        Assert.assertTrue(maxHeap.floor(array, 8) == 8);
        Assert.assertTrue(maxHeap.floor(array, 9) == 8);
        Assert.assertTrue(maxHeap.floor(array, 10) == 10);
        Assert.assertTrue(maxHeap.floor(array, 11) == 10);
        Assert.assertTrue(maxHeap.floor(array, 12) == 12);
        Assert.assertTrue(maxHeap.floor(array, 13) == 12);

        Assert.assertTrue(minHeap.floor(array, 0) == null);
        Assert.assertTrue(minHeap.floor(array, 1) == null);
        Assert.assertTrue(minHeap.floor(array, 2) == 2);
        Assert.assertTrue(minHeap.floor(array, 3) == 2);
        Assert.assertTrue(minHeap.floor(array, 4) == 4);
        Assert.assertTrue(minHeap.floor(array, 5) == 4);
        Assert.assertTrue(minHeap.floor(array, 6) == 6);
        Assert.assertTrue(minHeap.floor(array, 7) == 6);
        Assert.assertTrue(minHeap.floor(array, 8) == 8);
        Assert.assertTrue(minHeap.floor(array, 9) == 8);
        Assert.assertTrue(minHeap.floor(array, 10) == 10);
        Assert.assertTrue(minHeap.floor(array, 11) == 10);
        Assert.assertTrue(minHeap.floor(array, 12) == 12);
        Assert.assertTrue(minHeap.floor(array, 13) == 12);

        Assert.assertTrue(maxHeap.ceil(array, 0) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 1) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 2) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 3) == 4);
        Assert.assertTrue(maxHeap.ceil(array, 4) == 4);
        Assert.assertTrue(maxHeap.ceil(array, 5) == 6);
        Assert.assertTrue(maxHeap.ceil(array, 6) == 6);
        Assert.assertTrue(maxHeap.ceil(array, 7) == 8);
        Assert.assertTrue(maxHeap.ceil(array, 8) == 8);
        Assert.assertTrue(maxHeap.ceil(array, 9) == 10);
        Assert.assertTrue(maxHeap.ceil(array, 10) == 10);
        Assert.assertTrue(maxHeap.ceil(array, 11) == 12);
        Assert.assertTrue(maxHeap.ceil(array, 12) == 12);
        Assert.assertTrue(maxHeap.ceil(array, 13) == null);

        Assert.assertTrue(minHeap.ceil(array, 0) == 2);
        Assert.assertTrue(minHeap.ceil(array, 1) == 2);
        Assert.assertTrue(minHeap.ceil(array, 2) == 2);
        Assert.assertTrue(minHeap.ceil(array, 3) == 4);
        Assert.assertTrue(minHeap.ceil(array, 4) == 4);
        Assert.assertTrue(minHeap.ceil(array, 5) == 6);
        Assert.assertTrue(minHeap.ceil(array, 6) == 6);
        Assert.assertTrue(minHeap.ceil(array, 7) == 8);
        Assert.assertTrue(minHeap.ceil(array, 8) == 8);
        Assert.assertTrue(minHeap.ceil(array, 9) == 10);
        Assert.assertTrue(minHeap.ceil(array, 10) == 10);
        Assert.assertTrue(minHeap.ceil(array, 11) == 12);
        Assert.assertTrue(minHeap.ceil(array, 12) == 12);
        Assert.assertTrue(minHeap.ceil(array, 13) == null);
    }

    @Test
    public void test02(){
        Integer[] array = new Integer[]{2};

        Assert.assertTrue(maxHeap.floor(array, 0) == null);
        Assert.assertTrue(maxHeap.floor(array, 1) == null);
        Assert.assertTrue(maxHeap.floor(array, 2) == 2);
        Assert.assertTrue(maxHeap.floor(array, 3) == 2);
        Assert.assertTrue(maxHeap.floor(array, 4) == 2);
    

        Assert.assertTrue(minHeap.floor(array, 0) == null);
        Assert.assertTrue(minHeap.floor(array, 1) == null);
        Assert.assertTrue(minHeap.floor(array, 2) == 2);
        Assert.assertTrue(minHeap.floor(array, 3) == 2);
        Assert.assertTrue(minHeap.floor(array, 4) == 2);

        Assert.assertTrue(maxHeap.ceil(array, 0) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 1) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 2) == 2);
        Assert.assertTrue(maxHeap.ceil(array, 3) == null);
        Assert.assertTrue(maxHeap.ceil(array, 4) == null);

        Assert.assertTrue(minHeap.ceil(array, 0) == 2);
        Assert.assertTrue(minHeap.ceil(array, 1) == 2);
        Assert.assertTrue(minHeap.ceil(array, 2) == 2);
        Assert.assertTrue(minHeap.ceil(array, 3) == null);
        Assert.assertTrue(minHeap.ceil(array, 4) == null);
    }

    @Test
    public void test03(){
        Integer[] array = new Integer[]{};

        Assert.assertTrue(maxHeap.floor(array, 0) == null);
        Assert.assertTrue(maxHeap.floor(array, 1) == null);
        Assert.assertTrue(maxHeap.floor(array, 2) == null);
        Assert.assertTrue(maxHeap.floor(array, 3) == null);
        Assert.assertTrue(maxHeap.floor(array, 4) == null);
    

        Assert.assertTrue(minHeap.floor(array, 0) == null);
        Assert.assertTrue(minHeap.floor(array, 1) == null);
        Assert.assertTrue(minHeap.floor(array, 2) == null);
        Assert.assertTrue(minHeap.floor(array, 3) == null);
        Assert.assertTrue(minHeap.floor(array, 4) == null);

        Assert.assertTrue(maxHeap.ceil(array, 0) == null);
        Assert.assertTrue(maxHeap.ceil(array, 1) == null);
        Assert.assertTrue(maxHeap.ceil(array, 2) == null);
        Assert.assertTrue(maxHeap.ceil(array, 3) == null);
        Assert.assertTrue(maxHeap.ceil(array, 4) == null);

        Assert.assertTrue(minHeap.ceil(array, 0) == null);
        Assert.assertTrue(minHeap.ceil(array, 1) == null);
        Assert.assertTrue(minHeap.ceil(array, 2) == null);
        Assert.assertTrue(minHeap.ceil(array, 3) == null);
        Assert.assertTrue(minHeap.ceil(array, 4) == null);
    }

    @Test
    public void test04(){
        Integer[] array = null;

        Assert.assertTrue(maxHeap.floor(array, 0) == null);
        Assert.assertTrue(maxHeap.floor(array, 1) == null);
        Assert.assertTrue(maxHeap.floor(array, 2) == null);
        Assert.assertTrue(maxHeap.floor(array, 3) == null);
        Assert.assertTrue(maxHeap.floor(array, 4) == null);
    

        Assert.assertTrue(minHeap.floor(array, 0) == null);
        Assert.assertTrue(minHeap.floor(array, 1) == null);
        Assert.assertTrue(minHeap.floor(array, 2) == null);
        Assert.assertTrue(minHeap.floor(array, 3) == null);
        Assert.assertTrue(minHeap.floor(array, 4) == null);

        Assert.assertTrue(maxHeap.ceil(array, 0) == null);
        Assert.assertTrue(maxHeap.ceil(array, 1) == null);
        Assert.assertTrue(maxHeap.ceil(array, 2) == null);
        Assert.assertTrue(maxHeap.ceil(array, 3) == null);
        Assert.assertTrue(maxHeap.ceil(array, 4) == null);

        Assert.assertTrue(minHeap.ceil(array, 0) == null);
        Assert.assertTrue(minHeap.ceil(array, 1) == null);
        Assert.assertTrue(minHeap.ceil(array, 2) == null);
        Assert.assertTrue(minHeap.ceil(array, 3) == null);
        Assert.assertTrue(minHeap.ceil(array, 4) == null);
	}
}