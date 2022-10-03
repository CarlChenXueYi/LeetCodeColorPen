package SeventyOneToNinty;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int k : num) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<>();

            for (ArrayList<Integer> oldArr : result) {
                for (int j = 0; j < oldArr.size() + 1; j++) {
                    oldArr.add(j, k);
                    ArrayList<Integer> temp = new ArrayList<>(oldArr);
                    current.add(temp);
                    oldArr.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

    @Test
    public void test() {
        int[] num = new int[]{1, 2, 3};
        ArrayList<ArrayList<Integer>> permute = permute(num);
        for (ArrayList<Integer> list : permute) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println(permute.size());

    }

}
