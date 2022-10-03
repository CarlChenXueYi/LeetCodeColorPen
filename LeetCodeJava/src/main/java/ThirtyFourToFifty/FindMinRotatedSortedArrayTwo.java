package ThirtyFourToFifty;

import org.junit.jupiter.api.Test;

public class FindMinRotatedSortedArrayTwo {

    public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);

    }

    public static int findMin(int[] num, int left, int right) {
        if (right == left) {
            return num[left];
        }
        if (right == left + 1) {
            return Math.min(num[left], num[right]);
        }

        int middle = (right - left) / 2 + left;
        //already sorted
        if (num[right] > num[left]) {
            return num[left];
            //right shift one
        } else if (num[right] == num[left]) {
            return findMin(num, left + 1, right);
            //go right
        } else if (num[middle] >= num[left]) {
            return findMin(num, middle, right);
            //go left
        } else {
            return findMin(num, left, middle);
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{3, 3, 1, 3, 3, 3};
        System.out.println(findMin(arr));
    }


}
