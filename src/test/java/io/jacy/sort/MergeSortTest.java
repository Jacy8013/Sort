package io.jacy.sort;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(MergeSort::sort, 1000, 100);
    }
}
