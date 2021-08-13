package com.dkchoi;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;

public class CompletableCreateExample {
    public static void main(String[] args) {
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Throwable {
                int sum = 0;
                for(int i = 0; i < 100; i++) {
                    sum += i;
                }
                System.out.println("# 합계 " + sum);
                emitter.onComplete();
            }
        });

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                System.out.println("Complete");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }
}
