package week2;

import algo1.week2.Sol1;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TestMergeSort {

    @Test
    public void test1() throws Exception {
        assertArrayEquals(new int[]{1, 2}, Sol1.merge(new int[]{2}, new int[]{1}));
    }

    @Test
    public void test2() throws Exception {
        assertArrayEquals(new int[]{1, 2, 3, 4}, Sol1.merge(new int[]{2, 4}, new int[]{1, 3}));
    }

    @Test
    public void test4() throws Exception {
        assertArrayEquals(new int[]{1, 2, 3, 3, 4, 5, 5, 5, 5, 10, 10, 25, 25, 25, 30, 32}, Sol1.merge(new int[]{2, 4, 5, 5, 5, 10, 25, 32}, new int[]{1, 3, 3, 5, 10, 25, 25, 30}));
    }

}
