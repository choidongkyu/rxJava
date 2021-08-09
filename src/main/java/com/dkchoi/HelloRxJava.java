package com.dkchoi;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("Hello", "RxJava"); // 데이터 흐름 발행
        observable.subscribe(data -> System.out.println(data));
    }
}
