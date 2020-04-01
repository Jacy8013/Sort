package io.jacy.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 排序用到的通用方法
 *
 * @author Jacy
 */
public class ArrayUtils {

    /**
     * 初始化指定长度的数组
     *
     * @param length 数组长度
     * @return 指定长度数组
     */
    public static int[] initArray(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        length = Math.max(10, length);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    /**
     * 交换数组 pos1 与 pos2 位置的值
     *
     * @param array 数组
     * @param pos1  下标位置1
     * @param pos2  下标位置1
     */
    public static void swap(int[] array, int pos1, int pos2) {
        if (pos1 == pos2) {
            return;
        }

        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

    /**
     * 打印输出
     *
     * @param array 数组
     */
    public static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
