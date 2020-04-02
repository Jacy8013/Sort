package io.jacy.sort;

import org.junit.Test;

public class InsertionSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(InsertionSort::sortDefault, 1000, 100);
        CheckUtils.testSortTimes(InsertionSort::sort, 1000, 100);
    }
}
