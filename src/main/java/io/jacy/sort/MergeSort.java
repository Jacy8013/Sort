package io.jacy.sort;

/**
 * 归并排序
 *
 * @author Jacy
 */
public class MergeSort {
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * 这个方法每次拆分都需要分配2次额外空间, 可优化为只分配1次(但分配的是2倍空间)
     *
     * @param array
     */
    public static void merge(int[] array) {
        // 小于2个就可以不用再拆了
        if (array.length <= 2) {
            if (array[0] > array[array.length - 1]) {
                ArrayUtils.swap(array, 0, array.length - 1);
            }
            return;
        }

        // 对半拆分
        int half = array.length / 2;

        // 左半侧数组
        int[] left = new int[half];
        System.arraycopy(array, 0, left, 0, left.length);
        merge(left);

        // 右侧剩下部分
        int[] right = new int[array.length - half];
        System.arraycopy(array, half, right, 0, right.length);
        merge(right);

        // 合并逻辑
        for (int i = 0, lIndex = 0, rIndex = 0; i < array.length; i++) {
            if (lIndex >= left.length) {
                array[i] = right[rIndex++];
                continue;
            }
            if (rIndex >= right.length) {
                array[i] = left[lIndex++];
                continue;
            }
            array[i] = left[lIndex] <= right[rIndex] ? left[lIndex++] : right[rIndex++];
        }
    }

    /**
     * 递归拆分数组并合并
     *
     * @param array
     * @param start 开始位置
     * @param end   结束位置
     */
    private static void sort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }

        // 中间位置
        int mid = start + (end - start) / 2;

        // 左半侧数组及子数组
        sort(array, start, mid);

        // 右侧数组及子数组
        sort(array, mid + 1, end);

        // 合并
        merge(array, start, mid + 1, end);
    }

    /**
     * 合并操作
     * 从leftStartIndex和rightStartIndex开始, 找最小的放入缓存数组中, 直到选完所有的元素
     *
     * @param array
     * @param leftStartIndex  左侧起始位置
     * @param rightStartIndex 右侧起始位置, 相当于中间
     * @param rightBounds     右侧边界(最大下标)
     */
    private static void merge(int[] array, int leftStartIndex, int rightStartIndex, int rightBounds) {
        int[] temp = new int[rightBounds - leftStartIndex + 1];

        int l = leftStartIndex;
        int r = rightStartIndex;
        int t = 0;
        while (l < rightStartIndex && r <= rightBounds) {
            temp[t++] = array[l] <= array[r] ? array[l++] : array[r++];
        }
        while (l < rightStartIndex) {
            temp[t++] = array[l++];
        }
        while (r <= rightBounds) {
            temp[t++] = array[r++];
        }

        System.arraycopy(temp, 0, array, leftStartIndex, temp.length);
    }
}
