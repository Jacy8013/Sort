package io.jacy.sort;

import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(BubbleSort::sort, 1000, 100);
    }
}
