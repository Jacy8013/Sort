package io.jacy.sort;

/**
 * 插入排序
 * <p>
 * 原理: 从第1个元素开始, 依次与前面的所有元素比较, 当前无素较小就往前挪1位, 一直挪到所有比自己大的元素前面为止
 *
 * @author Jacy
 */
public class InsertionSort {
    /**
     * 调用最优版本
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i);
        }
    }

    /**
     * 插入排序默认版本, 当前元素与前1个位置的依次比较, 每次都交换
     *
     * @param array
     */
    public static void sortDefault(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[j] < array[j - 1]) {
                    ArrayUtils.swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * 把比当前值大的元素统一往后移1位
     *
     * @param array
     * @param i     从1开始
     */
    private static void insert(int[] array, int i) {
        int supposeMin = array[i];
        for (int j = i - 1; j >= 0; j--) {
            // 往后移一位
            if (supposeMin < array[j]) {
                array[j + 1] = array[j];

                // 当前值是数组中最小的时候
                if (j == 0) {
                    array[j] = supposeMin;
                }
            } else {
                // 前面没有比自己小数字了, 把自己放到当前位置的后1位, 退出
                array[j + 1] = supposeMin;
                break;
            }
        }
    }
}
