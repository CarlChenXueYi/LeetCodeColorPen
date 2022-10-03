package ThirtyFourToFifty;

import java.util.Arrays;

public class MinStack {
    private int[] arr = new int[100];
    private int index = 1;

    public void push(int x) {
        if (index == arr.length - 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[++index] = x;

    }

    public void pop() {
        if (index > -1) {
            if (index == arr.length / 2 && arr.length > 100) {
                arr = Arrays.copyOf(arr, arr.length / 2);
            }
            index--;
        }
    }

    public int top() {
        if (index > -1) {
            return arr[index];
        } else {
            return 0;
        }
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
