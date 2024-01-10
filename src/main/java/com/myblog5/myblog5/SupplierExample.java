package com.myblog5.myblog5;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

       Supplier<Integer>data=()-> new Random().nextInt(150);
        Integer y = data.get();
        System.out.println(y);
    }
}
