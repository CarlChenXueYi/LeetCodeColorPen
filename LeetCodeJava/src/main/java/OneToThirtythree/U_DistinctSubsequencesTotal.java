package OneToThirtythree;

import java.util.ArrayList;
import java.util.List;

public class U_DistinctSubsequencesTotal {
//    Given a string S and a string T, count the number of distinct
//    subsequences of T in S. A subsequence of a string is a new string
//    which is formed from the original string by deleting some
//    (can be none) of the characters without disturbing the relative
//    positions of the remaining characters. (ie, "ACE" is a subsequence
//    of "ABCDE" while "AEC" is not).
//    Here is an example: S = "rabbbit", T = "rabbit" Return 3.

    //Thoughts：When see string problem about subsequence,
    //dynamic programming should comes first.
    public static int numDistincts(String S, String T) {
        //W(i,j) stand for the number of subsequences of S(0,i) in T(0,j).
        //If S.charAt(i)==T.charAt(i) then W(i,j)=W(i-1,j-1)
        //else W(i-1,j)=W(i,j)
        int[][] table = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(i - 1)) {
                    table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
                } else {
                    table[i][j] += table[i - 1][j];
                }
            }
        }


        return table[S.length()][T.length()];
    }

}
