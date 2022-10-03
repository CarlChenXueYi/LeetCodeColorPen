package OneToThirtythree;

import org.junit.jupiter.api.Test;

import java.io.Serial;
import java.util.HashSet;
import java.util.LinkedList;

//BFS存在问题，会超出leetcode时间限制

public class WordLadder {
//    Given two words (start and end), and a dictionary, find the length of shortest trans-
//    formation sequence from start to end
//    Note: Return 0 if there is no such transformation sequence. All words have the same length.
//    All words contain only lowercase alphabetic characters.

    HashSet<String> dict = new HashSet<>() {
        @Serial
        private static final long serialVersionUID = 1L;

        {
            add("hot");
            add("dog");
            add("dot");
            add("log");
            add("lot");
        }
    };

    //    -------My Solution-----------
    //Degree of difference
    public static int degreeCalu(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }

    //列出差异度为1的字符串，进行改变
    //----error:存在bug------------
    public static int ladderLength1(String start, String end, HashSet<String> dict) {
        int len = 0;
        while (degreeCalu(start, end) != 0) {
            for (String str : dict) {
                if (degreeCalu(start, str) == 1) {
                    System.out.print(start + " ");
                    start = str;
                    len++;
                    break;
                }
            }
        }
        return len;
    }

    @Test
    public void test1() {
        System.out.println(ladderLength1("hit", "cog", dict));
    }
    //Naive Approach
    //In a simplest way, we can start from start word, change one character each time, if it is in the dictionary,
    // we continue with the replaced word, until start == end.
//    public static int ladderLength2(String start, String end, HashSet<String> dict){
//        int len=0;
//        int i;
//        for (i=0;i<start.length();i++){
//            char[] startArr=start.toCharArray();
//
//            for (char c='a';c<='z';c++){
//                if (c!=start.toCharArray()[i]){
//                    startArr[i]=c;
//                    String temp=new String(startArr);
//                    if (dict.contains(temp)){
//                        len++;
//                        start=temp;
//                        System.out.println(start);
//                        if (temp.equals(end)){
//                            return len;
//                        }
//                        i=0;
//                        break;
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//    @Test
//    public void test2(){
//        System.out.println(ladderLength2("hit","cog",dict));
//    }

    public int ladderLength3(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0) {
            return 0;
        }
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();
        wordQueue.add(start);
        distanceQueue.add(1);
        while (!wordQueue.isEmpty()) {
            String currentWord = wordQueue.pop();
            Integer currentDistance = distanceQueue.pop();
            if (currentWord.equals(end)) {
                return currentDistance;
            }

            for (int i = 0; i < currentWord.length(); i++) {
                char[] currCharArr = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currentDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }

    @Test
    public void test3() {
        System.out.println(ladderLength3("hit", "cog", dict));
    }

}