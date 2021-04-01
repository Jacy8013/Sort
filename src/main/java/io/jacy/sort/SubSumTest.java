package io.jacy.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jacy
 */
public class SubSumTest {
    static List<Integer> list = new ArrayList<>();

    static {
        for (int i = 3; i <= 3000; i++) {
            list.add(i);
        }
    }

    static int sum = 2000;
    static int len = 4;

    public static void sort(List<Integer> list, int sum, int len, int[] results) {

        if (len == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            results[results.length - len] = i;
        }
    }

    public static void main(String[] args) {
        sort(list, sum, len, new int[len]);

    }

    public static Integer sort(List<Integer> list, int l, int r, int sum) {
        int middle = l + (r - l) >> 1;
        if (list.size() < l || list.get(l) > sum) {
            return null;
        }
        int[] results = new int[2];
        int rIndex = 0;
        for (int i = l; i < middle + 1; i++) {
            if (list.get(l) < sum) {
                results[rIndex++] = list.get(l);
            }
        }
            return null;
    }

    static void sort1(List<Integer> list, int l, int r, int sum) {
        int middle = l + (r - l) >> 1;
        Integer min = sort(list, l, middle, sum);
        if (min == null) {
            return;
        }
        Integer max = sort(list, middle, r, sum - min);
    }
}
