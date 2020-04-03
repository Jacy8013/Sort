package io.jacy.sort;

/**
 * 希尔排序
 *
 * @author Jacy
 */
public class ShellSort {
    public static void sort(int[] array) {
        sortKnuth(array);
    }

    /**
     * 默认版本, 从插入排序默认版本改过来的
     *
     * @param array
     */
    public static void sortDefault(int[] array) {
        int gap = 4;
        for (int h = gap; h > 0; h >>= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (array[j] < array[j - h]) {
                        ArrayUtils.swap(array, j, j - h);
                    }
                }
            }
        }
    }

    /**
     * 优化版本, 从插入排序的优化版本改过来
     * gap = length / 2
     *
     * @param array
     */
    public static void sortOptimal(int[] array) {
        int gap = array.length >> 1;
        for (int h = gap; h > 0; h >>= 1) {
            insertPart(array, h);
        }
    }

    /**
     * 最优版本, 根据Knuth序列计算出gap值
     * <p>
     * h = 1;
     * h = 3 * h + 1;
     *
     * @param array
     */
    public static void sortKnuth(int[] array) {
        // 先根据knuth算出最大间隙值
        int gap = 1;
        while (gap <= array.length) {
            gap = 3 * gap + 1;
        }

        // 每次将自己下降为序列的上1个值
        for (int h = gap; h > 0; h = (h - 1) / 3) {
            insertPart(array, h);
        }
    }

    /**
     * 插队排序部分
     *
     * @param array
     * @param h     间隙值
     */
    private static void insertPart(int[] array, int h) {
        for (int i = h; i < array.length; i++) {
            int supposeMin = array[i];
            for (int j = i - h; j >= 0; j -= h) {
                if (supposeMin < array[j]) {
                    array[j + h] = array[j];
                    if (j < h) {
                        array[j] = supposeMin;
                    }
                } else {
                    array[j + h] = supposeMin;
                    break;
                }
            }
        }
    }
}
