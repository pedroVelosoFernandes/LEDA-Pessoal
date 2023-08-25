package orderStatistic;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;

public class testGetOrderStatistics {
    
    OrderStatistics implementacao;
    @Before
    public void setUp()
    {
        implementacao = new OrderStatisticsSelectionImpl<Integer>();
    }
    @Test
    public void test1(){
        Integer[] lista = new Integer[]{6,3,4,5};
        assertEquals(3,implementacao.getOrderStatistics(lista, 1));
    }
    public void test2(){
        Integer[] lista = new Integer[]{6,3,4,5};
        assertEquals(4,implementacao.getOrderStatistics(lista, 2));
    }
    public void test3(){ 
        Integer[] lista = new Integer[]{6,3,4,5};
        assertEquals(5,implementacao.getOrderStatistics(lista, 3));
    }
    public void test4(){ 
        Integer[] lista = new Integer[]{6,-99,4,5};
        assertEquals(-99,implementacao.getOrderStatistics(lista, 1));
    }
    public void test5(){ 
        Integer[] lista = new Integer[]{6};
        assertEquals(6,implementacao.getOrderStatistics(lista, 1));
    }
    public void test6(){ 
        Integer[] lista = new Integer[]{6};
        assertEquals(6,implementacao.getOrderStatistics(lista, 1));
    }
   
}
