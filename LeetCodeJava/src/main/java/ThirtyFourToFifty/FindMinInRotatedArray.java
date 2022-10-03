package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

public class FindMinInRotatedArray {
    public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public static int findMin(int[] num, int left, int right) {
        if (left == right) {
            return num[left];
        }
        if ((right - left) == 1) {
            return Math.min(num[left], num[right]);
        }

        int middle = left + (right - left) / 2;

        if (num[left] < num[right]) {
            return num[left];
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);
        } else {
            return findMin(num, left, middle);
        }

    }

    @Test
    public void test() {
        int[] arr = new int[]{4, 5, 6, 7, 1, 2, 3};
        System.out.println(findMin(arr));
    }
}
