package io.jacy.sort;

import org.junit.Test;

public class QuickSortTest {
    @Test
    public void test1() {
        CheckUtils.testSortTimes(QuickSort::sort2, 10, 1000);
    }

    @Test
    public void test2() {
        CheckUtils.testSortTimes(QuickSort::sort2, 1000, 10000);
    }
}
