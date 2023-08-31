package orderStatistic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;

public class orderStatisticTest {
    public QuickSelect<Integer> qSelect;
    public KLargestOrderStatisticsImpl<Integer> kLarg;

    @Before
    public void setup(){
        qSelect = new QuickSelect<Integer>();
        kLarg = new KLargestOrderStatisticsImpl<Integer>();
        
    }
    @Test
    public void test01(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 1);
        assertTrue(resposta == 0);
    }

    @Test
    public void test02(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 2);
        assertTrue(resposta == 11);
    }

    @Test 
    public void test03(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 3);
        assertTrue(resposta == 22);
    }

    @Test
    public void test04(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 4);
        assertTrue(resposta == 55);
    }

    @Test
    public void test05(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 5);
        assertTrue(resposta == 66);
    }

    @Test
    public void test06(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 6);
        assertTrue(resposta == 77);
    }

    @Test
    public void test07(){
        Integer[] array = new Integer[]{99,55,77,66,22,11,0};

        Integer resposta = qSelect.quickSelect(array, 7);
        assertTrue(resposta == 99);
    }
    
    @Test
    public void test08() {
        Integer[] array = new Integer[] { 99, 55, 77, 66, 22, 11, 0 };

        Integer resposta = qSelect.quickSelect(array, 9);
        assertTrue(resposta == null);
    }
    
    @Test
    public void test09() {
        Integer[] array = new Integer[] { 99, 55, 77, 66, 22, 11, 0 };

        Integer resposta = qSelect.quickSelect(array, 0);
        assertTrue(resposta == null);
    }
    
    @Test
    public void test10() {
        Integer[] array = new Integer[] { 99, 55, 77, 66, 22, 11, 0 };

        Integer resposta = qSelect.quickSelect(array, -4);
        assertTrue(resposta == null);
    }
    
    @Test
    public void test11() {
        Integer[] array = new Integer[] { 99 };

        Integer resposta = qSelect.quickSelect(array, 1);
        assertTrue(resposta == 99);
    }
    
   
}
