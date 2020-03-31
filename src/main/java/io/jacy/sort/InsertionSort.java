package io.jacy.sort;

/**
 * @author Jacy
 */
public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i);
        }
    }

    /**
     * 把比当前值大的元素统一往后移1位
     *
     * @param array
     * @param i     从1开始
     */
    private static void insert(int[] array, int i) {
        int current = array[i];
        for (int j = i - 1; j >= 0; j--) {
            // 往后移一位
            if (current < array[j]) {
                array[j + 1] = array[j];

                // 当前值是数组中最小的时候
                if (j == 0) {
                    array[j] = current;
                }
            } else {
                // 前面没有比自己小数字了, 把自己放到当前位置的后1位, 退出
                array[j + 1] = current;
                break;
            }

        }
    }
}
