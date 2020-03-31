package io.jacy.sort;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(SelectionSort::sort, 1000, 100);
    }
}
