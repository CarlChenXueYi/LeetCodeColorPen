package softAndHardCooperation;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Comment {
    public static void comment() throws IOException {
        int i = 1;
        String out = "";
        while (i < 10000) {
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();
            int temp = i % 6 == 0 ? 6 : i % 6;
            out = out + temp + ". 得分：" + a + "\n";
            if (temp == 6) {
                int sum = getSum(out);
                out = out + "\n总分： " + sum;
                fileWriterMethod("writer.txt", out);
                out = "";
            }
            System.out.println(temp + ". " + a);
            i++;
        }
    }

    public static void fileWriterMethod(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }

    public static int getSum(String comment) {
        String[] list = comment.split("[0-9]. 得分：");
//        . 得分：
        int sum = 0;
        int count = 0;
        for (String each : list) {
//            if (!each.equals("")){
//                int temp=Integer.parseInt(each.substring(0,2));
//                System.out.println(temp);
//            }
            count++;
            if (!each.equals("")) {
                String temp;
                if (count == 4) {
                    temp = each.substring(0, 1);
                } else {
                    temp = each.substring(0, 2);
                }
                int temp1 = Integer.parseInt(temp);
                sum += temp1;
                System.out.println(temp1);
            }
//            int temp=Integer.parseInt(each.substring(0,2));
        }
        System.out.println(sum);
        return sum;
    }

    public static String comments() {
        Scanner sc = new Scanner(System.in);
        StringBuilder ret = new StringBuilder();
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("输入第" + i + "题得分与错误原因：");
            String str = sc.nextLine();
            String[] list = str.split(" ");
            String temp;
            if (list.length == 1) {
                if (i == 1) {
                    temp = "选择题得分为:  " + Integer.parseInt(list[0]) + "\n";
                } else {
                    temp = i - 1 + ":得分为:  " + Integer.parseInt(list[0]) + "\n";
                }
            } else {
                if (i == 1) {
                    temp = "选择题得分为:  " + Integer.parseInt(list[0]) + "  备注： " + list[1] + "\n";
                } else {
                    temp = i - 1 + ":得分为:  " + Integer.parseInt(list[0]) + "  备注： " + list[1] + "\n";

                }
            }
            sum += Integer.parseInt(list[0]);
            ret.append(temp);
        }
        ret.append("总分为：").append(sum);
        return ret.toString();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 56; i++) {
            System.out.println(comments());
        }
    }
}
