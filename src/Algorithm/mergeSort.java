package Algorithm;

import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 100000;
        int[] test = new int[n];
        for (int i = 0; i < test.length; i++) {
            test[i] = (int) (Math.random() * 10000);
        }
        mergeSort(test);
        System.out.println(Arrays.toString(test));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

    }

    public static void mergeSort(int[] arr) {
        // Đệ quy
        // Basecase
        if (arr.length < 2) {
            return;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        // Gọi hàm đệ quy
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);

    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int indexLeft = 0;
        int indexRight = 0;

        for (int i = 0; i < arr.length; i++) {
            if (indexLeft >= left.length || (indexRight < right.length && left[indexLeft] >= right[indexRight])) {
                arr[i] = right[indexRight];
                indexRight++;
            } else {
                arr[i] = left[indexLeft];
                indexLeft++;
            }
        }
    }

};