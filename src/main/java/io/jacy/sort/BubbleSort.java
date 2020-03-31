package io.jacy.sort;

/**
 * 冒泡排序
 *
 * @author Jacy
 */
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // 默认相邻交换最大值到后一个位置
            // swapStep(array, i);

            // 交换后面比自己小的所有位置
            swapSteps(array, i);
        }
    }

    /**
     * 相邻比较交换最大的到后一个位置
     *
     * @param array
     * @param i
     */
    private static void swapStep(int[] array, int i) {
        for (int j = 0; j < i && array[j] > array[j + 1]; j++) {
            SortUtils.swap(array, j, j + 1);
        }
    }

    /**
     * 相邻比较
     * 如果相邻多位都比当前值小, 则当前值一次移多个位置
     * <p>
     * 相当于: 冒泡+插入
     *
     * @param array
     * @param i
     */
    private static void swapSteps(int[] array, int i) {
        int currentMax = array[0];
        for (int j = 1; j <= i; j++) {
            // 最大值比当前元素大, 就把当前元素往前移1个位置
            if (currentMax > array[j]) {
                array[j - 1] = array[j];

                // 当循环到未排序部分的最后一个元素, 最大值比最后一个元素还大, 需要把最大值放到最后一个位置上
                array[j] = j == i ? currentMax : array[j];
            } else {
                // 最大值不比当前元素大, 就把最大值放到当前元素前1个位置, 然后更新最大值
                array[j - 1] = currentMax;
                currentMax = array[j];
            }
        }
    }
}
