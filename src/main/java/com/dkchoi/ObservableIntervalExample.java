package com.dkchoi;

import com.dkchoi.util.TimeUtil;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {
    public static void main(String[] args) {
        Observable.interval(0L, 1000L, TimeUnit.MILLISECONDS)
                .map(num -> num + "count")
                .subscribe(data -> System.out.println(data));

        TimeUtil.sleep(3000);
    }
}
