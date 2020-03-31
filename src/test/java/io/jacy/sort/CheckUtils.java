package io.jacy.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.function.Consumer;

public class CheckUtils {
    public static void testSortTimes(Consumer<int[]> consumer, int length, int times) {
        for (int i = 0; i < Math.max(times, 1); i++) {
            int[] original = SortUtils.initArray(length);

            int[] dest = new int[original.length];
            System.arraycopy(original, 0, dest, 0, original.length);

            Arrays.sort(original);
            System.out.println(Arrays.toString(original));

            consumer.accept(dest);
            System.out.println(Arrays.toString(dest));

            Assert.assertArrayEquals(original, dest);
        }
    }
}
