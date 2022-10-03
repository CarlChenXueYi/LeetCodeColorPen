package stream_Java8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        //collection
        List<String> list = new ArrayList<>();
        list.add("cxy");
        //获取顺序流
        Stream<String> stream = list.stream();
        //获取并行流
        Stream<String> parallelStream = list.parallelStream();

        //转化数组
        Integer[] nums = new Integer[]{1, 2, 3};
        Stream<Integer> stream1 = Arrays.stream(nums);

        //使用Stream中的静态方法
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::print);
        System.out.println();
        stream3.forEach(System.out::print);
        System.out.println("\n-----------");

        //使用BufferRead
        BufferedReader reader = new BufferedReader(new FileReader("/Users/toma/Projects/LeetcodeJava/writer.txt"));
        Stream<String> lineStream = reader.lines();
        lineStream.forEach(System.out::print);
        System.out.println("\n-----------");

        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream = pattern.splitAsStream("a,b,c,d");
        stringStream.forEach(System.out::print);
        System.out.println("\n------------");

        System.out.println("\n流的中间操作");
//        filter：过滤流中的某些元素
//        limit(n)：获取n个元素
//        skip(n)：跳过n元素，配合limit(n)可实现分页
//        distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
        Integer[] nums1 = new Integer[]{2, 2, 4, 4, 8, 5, 10, 16, 9, 36, 49, 49, 64, 62};
        Stream<Integer> stream4 = Arrays.stream(nums1);
        Stream<Integer> newStream = stream4.filter(demo1::isSquare).distinct().skip(2).limit(2);
        newStream.forEach(System.out::println);
        System.out.println("---------------");


        List<String> list1 = Arrays.asList("a,b,c", "1,2,3");
        Stream<String> stream5 = list1.stream().map(s -> s.replaceAll(",", ""));
        stream5.forEach(System.out::println);
        Stream<String> stream6 = list1.stream().flatMap(s -> {
            String[] spilt = s.split(",");
            return Arrays.stream(spilt);
        });
        stream6.forEach(System.out::println);

        List<String> list2 = Arrays.asList("aa", "bb", "cc");
        list2.stream().sorted().forEach(System.out::println);

        stu s1 = new stu("aa", 10);
        stu s2 = new stu("aa", 20);
        stu s3 = new stu("bb", 30);
        stu s4 = new stu("dd", 20);
        List<stu> list3 = Arrays.asList(s1, s2, s3, s4);

        list3.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);
        System.out.println("\n------");

        //peek() 接受的是Consumer表达式，用来修改数据


        //流的终止操作
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        boolean allMatch = list4.stream().allMatch(e -> e > 10);
        boolean noneMatch = list4.stream().noneMatch(e -> e > 10);
        boolean anyMatch = list4.stream().anyMatch(e -> e > 4);

        Integer findFirst = list4.stream().findFirst().get();
        //返回任意元素
        Integer findAny = list4.stream().findAny().get();

        long count = list4.stream().count();
        Integer max = list4.stream().max(Integer::compareTo).get();
        Integer min = list4.stream().min(Integer::compareTo).get();

        //规约操作
//        Stream中的Reduce方法：根据一定的规则将Stream中的元素进行计算后返回一个唯一的值，
//        它有三个变种，输入参数分别是一个参数、二个参数以及三个参数。
        //单参数
        Stream<Integer> stream7 = Stream.of(1, 2, 3, 4, 5, 6);
        Integer sum = stream7.reduce((a, b) -> a - b).get();
        System.out.println(sum);

        //双参数,第一个参数相当于初始参数
        Stream<String> stringStream1 = Stream.of("test", "t1", "t2", "teee", "aaaa", "taaa");
        System.out.println(stringStream1.reduce("[value]", String::concat));

        //


    }

    public static boolean isSquare(Integer num) {
        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
