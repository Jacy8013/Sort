package io.jacy.sort;

import org.junit.Test;

public class ShellSortTest {
    @Test
    public void testSort() {
        CheckUtils.testSortTimes(ShellSort::sortDefault, 1000, 100);
        CheckUtils.testSortTimes(ShellSort::sortOptimal, 997, 100);
        CheckUtils.testSortTimes(ShellSort::sort, 1000, 100);
    }
}
