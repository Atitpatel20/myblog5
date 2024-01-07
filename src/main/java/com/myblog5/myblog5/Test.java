package com.myblog5.myblog5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//       Predicate<Integer> val= y->y%2==0;
//        boolean result = val.test(25);
//        System.out.println(result);

//       Predicate<String> val= str->str.equals("samir");
//        boolean result = val.test("kirtan");
//        System.out.println(result);

//        List<Integer> numbers = Arrays.asList(10, 25, 36, 14, 28, 34, 11, 20, 31);
//        List<Integer> res = numbers.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
//        System.out.println(res);


//        List<Integer> numbers = Arrays.asList(11, 25, 35, 14, 26, 33, 19, 54, 91);
//        List<Integer> oddNumbers = numbers.stream().filter(s -> s % 2 != 0).collect(Collectors.toList());
//        System.out.println(oddNumbers);

        List<String> names = Arrays.asList("mike", "kiyaraa", "karan", "priyank", "kiyaraa");
        List<String> data1 = names.stream().filter(str -> str.startsWith("p")).collect(Collectors.toList());
        List<String> data2 = names.stream().filter(str -> str.equals("kiyaraa")).collect(Collectors.toList());
        List<String> data3 = names.stream().filter(str -> str.endsWith("e")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);

    }
}
