package io.jacy.sort;

/**
 * @author Jacy
 */
public class ShellSort {
    public static void sort(int[] array) {
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.initArray(10);
        ArrayUtils.print(array);
        sort(array);
        ArrayUtils.print(array);
    }
}
