package io.jacy.sort;

/**
 * 归并排序
 *
 * @author Jacy
 */
public class MergeSort {
    public static void sort(int[] array) {
        merge(array);
    }

    private static void merge(int[] array) {
        // 小于2个就可以不用再拆了
        if (array.length <= 2) {
            if (array[0] > array[array.length - 1]) {
                ArrayUtils.swap(array, 0, array.length - 1);
            }
            return;
        }

        // 对半拆分
        int half = array.length / 2;

        // 左边一半数组
        int[] left = new int[half];
        System.arraycopy(array, 0, left, 0, left.length);
        merge(left);

        // 右边剩下数组
        int[] right = new int[array.length - half];
        System.arraycopy(array, half, right, 0, right.length);
        merge(right);

        // 合并逻辑
        for (int i = 0, lIndex = 0, rIndex = 0; i < array.length; i++) {
            if (lIndex >= left.length) {
                array[i] = right[rIndex];
                rIndex++;
                continue;
            }
            if (rIndex >= right.length) {
                array[i] = left[lIndex];
                lIndex++;
                continue;
            }
            if (left[lIndex] <= right[rIndex]) {
                array[i] = left[lIndex];
                lIndex++;
            } else {
                array[i] = right[rIndex];
                rIndex++;
            }
        }
    }
}
