package com.myblog5.myblog5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<Worker> workers = Arrays.asList(
                new Worker("jigar", "fitter", 29),
                new Worker("mayur", "electrician", 27),
                new Worker("anil", "electrician", 30),
                new Worker("mehul", "cnc", 32),
                new Worker("shubhas", "lathe", 45)
        );
        Map<Integer, List<Worker>> collect = workers.stream().collect(Collectors.groupingBy(str -> str.getAge()));

        for ( Map.Entry<Integer,List<Worker>> entry: collect.entrySet()) {

            Integer age = entry.getKey();
            List<Worker> detailes = entry.getValue();
            System.out.println("age: "+ age+"---");
            for (Worker  w: detailes) {
                System.out.println(w.getName());
                System.out.println(w.getDesignation());
            }

        }

    }
}
