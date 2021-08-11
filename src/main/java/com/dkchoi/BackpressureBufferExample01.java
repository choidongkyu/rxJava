package com.dkchoi;

import com.dkchoi.util.LogType;
import com.dkchoi.util.Logger;
import com.dkchoi.util.TimeUtil;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackpressureBufferExample01 {
    public static void main(String[] args) {
        Flowable.interval(300L, TimeUnit.MILLISECONDS)
                //doOnNext는 데이터가 통지될때 불리는 메소드
                .doOnNext(data -> System.out.println("#inverval doOnNext() , " + data))
                .onBackpressureBuffer( // 배압 전략중 하나인 버퍼방식
                        2, //버퍼 용량
                        () -> System.out.println("overFlow!"), //오버플로우가 날때의 처리 함수
                        BackpressureOverflowStrategy.DROP_LATEST) // 가장 최근에 들어온 데이터를 비우도록 전략 지정
                .doOnNext(data -> System.out.println("#onBackpressuerBuffer doOnNext() , " + data))
                .observeOn(Schedulers.computation(), false, 1)// 데이터 처리 쓰레드 따로 지정
                .subscribe(
                        data -> {
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error)
                );
        TimeUtil.sleep(2800L);

    }
}
