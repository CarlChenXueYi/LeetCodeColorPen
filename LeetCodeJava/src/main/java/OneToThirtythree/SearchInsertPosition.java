package OneToThirtythree;

import org.junit.jupiter.api.Test;

public class SearchInsertPosition {
    public static int searchInsertPos1(int[] A, int target) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                index = i;
                break;
            }
            if (i == A.length - 1) {
                return A.length;
            }
        }
        return index;
    }

    //binary search
//    public static int searchInsert2(int[] A,int target){
//        int begin=0;
//        int end=A.length-1;
//        if (end==-1){
//            return 0;
//        }
//        if (end==0){
//            if (A[0]>target){
//                return 0;
//            }
//            else{
//                return 1;
//            }
//        }
//        int mid=0;
//        while (begin<end){
//            mid=begin+(end-begin)/2;
//            if (A[mid]>target){
//                end=mid-1;
//            }else if (A[mid]<target){
//                begin=mid+1;
//            }else {
//                return mid;
//            }
//        }
//        if (mid==0){
//            return 0;
//        }
//
//
//
//    }

    @Test
    public void test() {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsertPos1(a, 5));
        System.out.println(searchInsertPos1(a, 2));
        System.out.println(searchInsertPos1(a, 7));
        System.out.println(searchInsertPos1(a, 0));

    }
}
