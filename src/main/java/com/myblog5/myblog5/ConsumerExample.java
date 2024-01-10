package com.myblog5.myblog5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> result=names-> System.out.println(names);
        result.accept("testing");

        List<String> names = Arrays.asList("kevin", "priyal", "chirag");
        Consumer<String>val= name-> System.out.println(name);
        names.forEach(val);
    }
}
