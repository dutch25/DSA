package Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 10, 12, 1, 5, 6}; {
            for (int step = 1; step < arr.length; step++) {
                int j = step - 1;
                int key = arr[step];
                while (j >= 0 && key < arr[j]) {
                    arr[j + 1] = arr [j];
                    --j;
                }
                arr[j + 1] = key;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
