package io.jacy.sort;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test1() {
        CheckUtils.testSortTimes(QuickSort::sort2, 100, 10000);
    }

    @Test
    public void test2() {
        CheckUtils.testSortTimes(QuickSort::sort2, 100, 10000);
    }

    @Test
    public void test3() {
        CheckUtils.testSortTimes(QuickSort::sort3, 100, 10000);
    }
}
