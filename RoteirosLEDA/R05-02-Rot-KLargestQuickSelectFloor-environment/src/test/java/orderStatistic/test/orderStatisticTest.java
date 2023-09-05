package orderStatistic.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;

public class orderStatisticTest {
    private Integer[] array;
    public QuickSelect<Integer> qSelect;
    public KLargestOrderStatisticsImpl<Integer> kLarg;

    @Before
    public void setup(){
        qSelect = new QuickSelect<Integer>();
        kLarg = new KLargestOrderStatisticsImpl<Integer>();
        array = new Integer[] {3,2,1,6,5,4,90,80,70,100};
    }
    @Test
    public void test01(){
        assertEquals(qSelect.quickSelect(array, 1), (Integer) 1 );
    }
    
    @Test
    public void test02() {
        assertEquals(qSelect.quickSelect(array, 2), (Integer) 2);
    }
    
    @Test
    public void test03() {
        assertEquals(qSelect.quickSelect(array, 9), (Integer) 90);
    }
    
    @Test
    public void test04() {
        assertEquals(qSelect.quickSelect(array, 8), (Integer) 80);
    }
    
    @Test
    public void test05() {
        assertEquals(qSelect.quickSelect(array, 10), (Integer) 100);
    }

    @Test
    public void test06() {
        assertEquals(qSelect.quickSelect(array, 0),null);
    }
    
    @Test
    public void test07() {
        assertEquals(qSelect.quickSelect(null, 0), null);
    }
    
    @Test
    public void test08() {
        assertEquals(qSelect.quickSelect(array, 20), null);
    }
  
    @Test
    public void test09() {
         Integer[] resposta = new Integer[]{80,90,100};
        assertArrayEquals(kLarg.getKLargest(array, 3),resposta);
    }
    
    @Test
    public void test10() {
        Integer[] resposta = new Integer[] {1,2,3,4,5,6,70,80,90,100};
        assertArrayEquals(kLarg.getKLargest(array, 10), resposta);
    }
    
    @Test
    public void test11() {
        Integer[] resposta = new Integer[] { 100 };
        assertArrayEquals(kLarg.getKLargest(array, 1), resposta);
    }
    
    @Test
    public void test12() {
        Integer[] resposta = new Integer[] {  };
        assertArrayEquals(kLarg.getKLargest(array, 0), resposta);
    }
    
    @Test
    public void test13() {
        Integer[] resposta = new Integer[] {};
        assertArrayEquals(kLarg.getKLargest(array, 11), resposta);
    }
    
    @Test
    public void test14() {
        Integer[] resposta = new Integer[] {};
        assertArrayEquals(kLarg.getKLargest(null, 1), resposta);
    }
    
    @Test
    public void test15() {
        Integer[] resposta = new Integer[] {};
        assertArrayEquals(kLarg.getKLargest(array, 0), resposta);
    }
    
   
}
