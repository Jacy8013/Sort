package io.jacy.exam;

/**
 * 可以用归并排序思想解决的问题
 *
 * @author Jacy
 */
public class MergeSortExam {

    /**
     * 给定数组, 求数组中右侧比自己小的所有的数的组合(逆序对)
     * [1,5,3,2,4]
     * [1,5]:       无
     * [1,5,2]:     [5,2]
     * [1,5,3,2]:   [5,3][5,2]
     * [1,5,3,2,4]: [5,3][5,2][5,4]
     * <p>
     * ==> [5,2][5,3][5,4]
     *
     * @author Jacy
     */
    public static class DescPairs {
        public static void main(String[] args) {
            int[] array = new int[]{1, 5, 3, 2, 4};

            process(array, 0, array.length - 1);
        }

        private static void process(int[] array, int l, int r) {
            if (l == r) {
                return;
            }

            int middle = l + ((r - l) >> 1);
            process(array, l, middle);
            process(array, middle + 1, r);

            merge(array, l, middle, r);
        }

        static void merge(int[] array, int l, int middle, int r) {
            int[] temp = new int[r - l + 1];
            int index = 0;
            int lIndex = l;
            int rIndex = middle + 1;

            while (lIndex <= middle && rIndex <= r) {

                if (array[lIndex] > array[rIndex]) {
                    System.out.println("[" + array[lIndex] + "," + array[rIndex] + "]");
                }

                // 原则: 只有左数组当前值 小于 右数组当前值才copy+移动下标(归并排序有等于)
                temp[index++] = array[lIndex] <= array[rIndex] ? array[lIndex++] : array[rIndex++];
            }

            while (lIndex <= middle) {
                temp[index++] = array[lIndex++];
            }

            while (rIndex <= r) {
                temp[index++] = array[rIndex++];
            }

            System.arraycopy(temp, 0, array, l, temp.length);
        }
    }

    /**
     * 给定数组, 求数组中所有左侧比当前位置小的数的总和(小和问题)
     * [1,3,2,4,5]
     * [1,3]:       1
     * [1,3,2]:     1
     * [1,3,2,4]:   1,3,2
     * [1,3,2,4,5]: 1,3,2,4
     * ==> 1 + 1 + 1 + 3 + 2 + 1 + 3 + 2 + 4 = 18
     *
     * @author Jacy
     */
    public static class SmallSum {
        public static void main(String[] args) {
            int[] array = new int[]{1, 3, 2, 4, 5};
            System.out.println(process(array, 0, array.length - 1));
        }

        private static int process(int[] array, int l, int r) {
            if (l == r) {
                return 0;
            }

            int middle = l + ((r - l) >> 1);

            return process(array, l, middle)
                    + process(array, middle + 1, r)
                    + merge(array, l, middle, r);
        }

        private static int merge(int[] array, int l, int middle, int r) {
            int[] temp = new int[r - l + 1];
            int index = 0;
            int lIndex = l;
            int rIndex = middle + 1;

            int sum = 0;
            while (lIndex <= middle && rIndex <= r) {
                sum += array[lIndex] < array[rIndex] ? (r - rIndex + 1) * array[lIndex] : 0;

                // 原则: 只有左数组当前值 小于 右数组当前值才copy+移动下标(归并排序有等于)
                temp[index++] = array[lIndex] < array[rIndex] ? array[lIndex++] : array[rIndex++];
            }

            while (lIndex <= middle) {
                temp[index++] = array[lIndex++];
            }

            while (rIndex <= r) {
                temp[index++] = array[rIndex++];
            }

            System.arraycopy(temp, 0, array, l, temp.length);
            return sum;
        }
    }
}
