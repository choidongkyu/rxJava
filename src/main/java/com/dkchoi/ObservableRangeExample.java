package com.dkchoi;

import io.reactivex.rxjava3.core.Observable;

public class ObservableRangeExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(0, 5);
        source.subscribe(num -> System.out.println(num));
    }
}
