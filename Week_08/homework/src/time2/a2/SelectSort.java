package time2.a2;

public class SelectSort {
    /**
     * 比较排序之选择排序
     *
     * 选择排序就是每次找到最小值和未排数组的头进行交换
     */

    /**
     * 时间复杂度为 O(n ^ 2)
     * 思路是关键
     */
    public static void arrSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return ;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 8, 14, 6, 7, 10};
        arrSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // arrSort(new int[0]);
    }
}
