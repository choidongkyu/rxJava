package com.dkchoi;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ClassNameStaticMethodExample {
    public static void main(String[] args) {
        Function<String, Integer> f = Integer::parseInt;
        System.out.println(f.apply("3"));

        //메서드 레퍼런스 예제
        // 문제 1번
        Predicate<String> p1 = s -> s.isEmpty();

        // 문제 1번 정답
        Predicate<String> p2 = String::isEmpty;
        System.out.println("문제 1번 결과: " + p2.test("Not Empty"));

        // 문제 2번
        Function<Integer, String> f1 = i -> String.valueOf(i);

        // 문제 2번 정답
        Function<Integer, String> f2 = String::valueOf;
        System.out.println("문제 2번 결과: " + f2.apply(3));

        // 문제 3번
        BiPredicate<List<Integer>, Integer> bp1 = (list, num) -> list.contains(num);

        // 문제 3번 정답
        BiPredicate<List<Integer>, Integer> bp2 = List::contains;
        System.out.println("문제 3번 결과: " + bp2.test(Arrays.asList(1, 3, 5, 7, 9), 9));

        //문제 4번
        Consumer<String> c1 = s -> System.out.println(s);

        // 문제 4번 정답
        Consumer<String> c2 = System.out::println;
        c2.accept("문제 4번 결과: Hello!");
    }
}
