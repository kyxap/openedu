package week1;

import algo1.week1.Solution5SecretSwap2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBS {

    @Test
    public void test1() throws Exception {
        assertEquals(2, Solution5SecretSwap2.binarySearch(new int[]{80, 90, 91, 86, 85, 10, 10, 9, 20}, 1, 91));
    }

    @Test
    public void test11() throws Exception {
        assertEquals(1, Solution5SecretSwap2.binarySearch(new int[]{80, 90}, 1, 91));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(1, Solution5SecretSwap2.binarySearch(new int[]{80, 90, 91, 86, 85, 10, 10, 9, 20}, 2, 86));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(0, Solution5SecretSwap2.binarySearch(new int[]{80, 90, 91, 86, 85, 10, 10, 9, 20}, 2, 76));
    }


    @Test
    public void test4() throws Exception {
        assertEquals(4, Solution5SecretSwap2.binarySearch(new int[]{80, 90, 91, 92, 95, 10, 10, 9, 20}, 4, 94));
    }

    @Test
    public void test5() throws Exception {
        assertEquals(4, Solution5SecretSwap2.binarySearch(new int[]{80, 90, 91, 92, 93}, 4, 94));
    }
}
