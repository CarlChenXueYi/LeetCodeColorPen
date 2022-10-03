package OneToThirtythree;//You may have been using Java for a while. Do you think a simple Java array question can be a challenge? Let’s use the following problem to test.
//        Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//        How many different ways do you know to solve this problem?

import org.junit.jupiter.api.Test;

public class RotateArrayInJava {
    private static final int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    private static final int k = 3;

    //my solution
    public static void rotate(int[] nums, int k) {
        //注意k大于数组长度的情况
        if (k > nums.length) k = k % nums.length;
        localRotate(nums, 0, nums.length - k - 1);
        localRotate(nums, nums.length - k, nums.length - 1);
        localRotate(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void localRotate(int[] nums, int from, int to) {
        for (int i = 0; i <= (to - from) / 2; i++) {
            int temp = nums[from + i];
            nums[from + i] = nums[to - i];
            nums[to - i] = temp;
        }
//        for(int num:nums){
//            System.out.print(num);
//        }
    }

    //s1 intermediate array
    public static void rotate1(int[] nums, int k) {
        if (k > nums.length) k = k % nums.length;

        int[] result = new int[nums.length];

        System.arraycopy(nums, nums.length - k, result, 0, k);
        System.arraycopy(nums, 0, result, k, nums.length - k);
        System.arraycopy(result, 0, nums, 0, nums.length);
        for (int num : nums) System.out.print(num);

    }

    //s2 bubble rotate
    public static void rotate2(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument");
        }
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }

    @Test
    public void test0() {
        rotate(nums, k);
    }

    @Test
    public void test1() {
        rotate1(nums, k);
    }

}
