package com.ray.securitydemo.curry;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurryTest {

    public static void main(String[] args) {

        Function<String, Function<String, Function<String, String>>>
                f = a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> f1 = f.apply("hello ");

        Function<String, String> f2 = f1.apply("cxl ");

        System.out.println(f2.apply(" ha ha"));


        Function<String, String> a = s -> s + "ha ha";
        Function<String, String> b = s -> s + "la la";
        Function<String, String> c = a.andThen(b);
        System.out.println(c.apply("cxl"));


        Map<String, String> map =
                Stream.of("123", "1234").collect(Collectors.toMap(Function.identity(), Function.identity()));

        System.out.println(map);

    }

}
