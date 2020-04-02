package io.jacy.sort;

/**
 * 选择排序
 *
 * @author Jacy
 */
public class SelectionSort {

    public static void sort(int[] array) {
        // 一次选出最大最小两个值做排序
        sortMinAndMax(array);
    }

    /**
     * 默认版本的选择排序算法
     *
     * @param array
     */
    public static void sortDefault(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minValuePos = i;
            for (int j = i + 1; j < array.length; j++) {
                minValuePos = array[j] < array[minValuePos] ? j : minValuePos;
            }

            ArrayUtils.swap(array, i, minValuePos);
        }
    }

    /**
     * 同时选出最大最小两个值做排序
     *
     * @param array
     */
    private static void sortMinAndMax(int[] array) {
        for (int i = 0; i < Math.ceil((array.length) / 2d); i++) {
            swapMaxAndMin(array, i);
        }
    }


    /**
     * 选出最小交换到最前位置
     * 选出最大交换到最后位置
     *
     * @param array
     * @param i
     */
    private static void swapMaxAndMin(int[] array, int i) {
        int minValuePos = i;
        int maxValuePos = i;
        for (int j = i + 1; j < array.length - i; j++) {
            if (array[j] < array[minValuePos]) {
                minValuePos = j;
            }
            if (array[j] > array[maxValuePos]) {
                maxValuePos = j;
            }
        }

        ArrayUtils.swap(array, i, minValuePos);

        // 情况1: i位置的数刚好是最大值, 被65行最小值交换后, 后面再交换就会出错
        // 情况2: i位置的数刚好是最大值, length-1-i位置刚好是最小值, 65行交换后, 后面再交换会再把它们交换回来
        // 因此需要更新最大值位置为交换后的位置
        maxValuePos = i == maxValuePos ? minValuePos : maxValuePos;
        ArrayUtils.swap(array, array.length - 1 - i, maxValuePos);
    }
}
