package io.jacy.sort;

import java.util.List;

/**
 * 堆排序
 *
 * @author Jacy
 */
public class HeapSort {
    public void sort(int[] array) {

    }

    public static void heapInsert(List<Integer> array, int n) {
        array.add(n);


//        for (int j = 0; j < array.size(); j++) {
//            array
//        }
        int i = 0;
        int tmp = n;
        while (i < array.size()) {
            if (i + 1 == array.size()) {
                array.add(n);
                break;
            }

            if (array.get(i) < tmp) {
                tmp = array.get(i);
                array.set(i, n);
//                n = tmp;
                break;
            }

            if ((tmp = array.get(i + 1)) < n) {
                array.set(i + 1, n);
//                n = tmp;
                break;
            }

            i = 2 * i + 1;
        }
    }
}
