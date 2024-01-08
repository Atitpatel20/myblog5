package com.myblog5.myblog5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
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

//        List<String> names = Arrays.asList("mike", "kiyaraa", "karan", "priyank", "kiyaraa");
//        List<String> data1 = names.stream().filter(str -> str.startsWith("p")).collect(Collectors.toList());
//        List<String> data2 = names.stream().filter(str -> str.equals("kiyaraa")).collect(Collectors.toList());
//        List<String> data3 = names.stream().filter(str -> str.endsWith("e")).collect(Collectors.toList());
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data3);

        //find the length of given string
//       Function<String,Integer> val=str->str.length();
//        Integer result = val.apply("pankajSirAcadamy");
//        System.out.println(result);

        // add the numbers in given number
//        Function<Integer,Integer>val=i->i+10;
//        Integer result = val.apply(25);
//        System.out.println(result);

        // add +25 in all given numbers
//        List<Integer> numbers = Arrays.asList(15, 35, 65, 85, 95);
//        List<Integer> result = numbers.stream().map(i -> i + 10).collect(Collectors.toList());
//        System.out.println(result);
        
        // i want all the name in upper case
//        List<String> names = Arrays.asList("mike", "stallin", "adam", "nilay");
//        List<String> res1 = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
//        List<String> res2 = names.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//        System.out.println(res1);
//        System.out.println(res2);

        // sort the all given name in ascending order
//        List<String> names = Arrays.asList("mike", "stallin", "adam", "nilay");
//        List<String> result = names.stream().sorted().collect(Collectors.toList());
//        System.out.println(result);

        // sort all the given numbers in ascending order
//        List<Integer> numbers = Arrays.asList(15, 24, 36, 10, 58, 45, 34);
//        List<Integer> result = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println(result);

        // sort all the numbers & remove all duplicate numbers from list
        List<Integer> numbers = Arrays.asList(10, 41,25,5, 30, 64,40, 25, 67, 30, 45);
        List<Integer> result1 = numbers.stream().distinct().collect(Collectors.toList());
        List<Integer> result2 = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(result1);
        System.out.println(result2);
    }
}
