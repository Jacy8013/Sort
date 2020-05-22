package io.jacy.sort;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(MergeSort::merge, 1001, 100);
        CheckUtils.testSortTimes(MergeSort::sort, 1000, 100);
        CheckUtils.testSortTimes(MergeSort::sortIterator, 1000, 100);
    }
}
