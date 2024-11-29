package Algorithm;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = { 8, 7, 5, 2 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // vong lap 1, j chay tu 8 -> 5; 7 5 2 8
                // Vong lap 2, j chay 7 -> 5; 5 2 7 8
                // Vong lap thu 3, j chay 5 -> 5; 2 5 7 8
                // (8) 7 5 2
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    swap(arr, j, j + 1);
                }
            }
            System.out.println("Sorted array:" + Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}