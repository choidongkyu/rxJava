package com.dkchoi;

import com.dkchoi.util.DateUtil;
import com.dkchoi.util.LogType;
import com.dkchoi.util.Logger;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class SingleCreateExample {
    public static void main(String[] args) {
        Single<String> single = Single.create(emitter -> {
            emitter.onSuccess(DateUtil.getNowDate());
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onSuccess(@NonNull String s) {
                Logger.log(LogType.ON_SUCCESS, "# 날짜시각: "+ s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }
        });
    }
}
