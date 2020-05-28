package io.jacy.sort;

import java.util.Arrays;

/**
 * 快排
 *
 * @author Jacy
 */
public class QuickSort {

    public static void sort1(int[] array) {
        sort1(array, 0, array.length - 1);
    }

    /**
     * 处理<=区域
     *
     * @param array
     * @param l     left
     * @param r     right
     * @return middle
     */
    private static int partition1(int[] array, int l, int r) {
        int lessIndex = l - 1;
        int n = array[r];
        for (int i = l; i < r; i++) {
            if (array[i] <= n) {
                ArrayUtils.swap(array, ++lessIndex, i);
            }
        }
        ArrayUtils.swap(array, lessIndex + 1, r);
        return lessIndex;
    }

    private static void sort1(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = partition1(array, l, r);
        sort1(array, l, m);
        sort1(array, m + 1, r);
    }


    public static void sort2(int[] array) {
        sort2(array, 0, array.length - 1);
    }

    /**
     * 同时处理<,=,>区域
     *
     * @param array
     * @param l     left
     * @param r     right
     * @return middle
     */
    private static int[] partition2(int[] array, int l, int r) {
        int lessIndex = l - 1;
        int moreIndex = r;

        int i = l;
        int n = array[r];
        while (i < moreIndex) {
            if (array[i] < n) {
                ArrayUtils.swap(array, ++lessIndex, i++);
            } else if (array[i] > n) {
                ArrayUtils.swap(array, --moreIndex, i);
            } else {
                i++;
            }
        }
        ArrayUtils.swap(array, moreIndex, r);

        return new int[]{lessIndex, moreIndex};
    }

    private static void sort2(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int[] lessAndMore = partition2(array, l, r);
        sort2(array, l, lessAndMore[0]);
        sort2(array, lessAndMore[1] + 1, r);
    }


    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 2, 1, 3, 9, 9, 2, 6, 2};
        System.out.println(Arrays.toString(array));
        sort2(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
