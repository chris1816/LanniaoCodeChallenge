package com.twitter.challenge;

import android.util.Log;

import com.twitter.challenge.data.Forecast;
import com.twitter.challenge.network.ApiService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function5;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {

    @Inject
    Retrofit retrofit;

    private ApiService apiService;

    public Repository() {
        MyApplication.getComponentInstance().injectRetrofit(this);
        apiService = retrofit.create(ApiService.class);

    }

    public void fetchWeather(final NetworkCallback callback) {
        Disposable disposable =  apiService.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Forecast>() {
                    @Override
                    public void accept(Forecast forecast) throws Exception {
                        callback.getForeCast(forecast);
                    }
                });

/*        Call<Forecast> call = apiService.getForecast();
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                callback.getForeCast(response.body());
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });*/
    }

    public void fetchFiveDaysWeather(final NetworkCallback callback) {

//            List<Observable<Forecast>> requests = new ArrayList<>();
/*        requests.add(apiService.getFirstDayForecast());
        requests.add(apiService.getSecondDayForecast());
        requests.add(apiService.getThirdDayForecast());
        requests.add(apiService.getFourthDayForecast());
        requests.add(apiService.getFifthDayForecast());*/

        Observable o1 = apiService.getFirstDayForecast();
        Observable o2 = apiService.getSecondDayForecast();
        Observable o3 = apiService.getThirdDayForecast();
        Observable o4 = apiService.getFourthDayForecast();
        Observable o5 = apiService.getFifthDayForecast();

        Disposable disposable = Observable.zip(o1, o2, o3, o4, o5, new Function5<Forecast,
                Forecast, Forecast, Forecast, Forecast, ArrayList<Forecast>>() {
            @Override
            public ArrayList<Forecast> apply(Forecast o, Forecast o2, Forecast o3, Forecast o4, Forecast o5) throws Exception {
                ArrayList<Forecast> res = new ArrayList<>();
                res.add(o);
                res.add(o2);
                res.add(o3);
                res.add(o4);
                res.add(o5);
                return res;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<Forecast>>() {

            @Override
            public void accept(ArrayList<Forecast> forecast) throws Exception {
                Log.e("sss", "yes");
                callback.getFiveDaysForecast(forecast);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (throwable == null) {
                    Log.e("ssss", "???");
                } else {
                    Log.e("ssss", throwable.getMessage());
                }
            }
        });



/*        Disposable disposable = Observable.zip(o1, o2, new BiFunction<Forecast, Forecast, Forecast>() {
            @Override
            public Forecast apply(Forecast o1, Forecast o2) throws Exception {

                return o1;

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Forecast>() {

            @Override
            public void accept(Forecast forecast) throws Exception {
//                callback.getFiveDaysForecast(forecast);
            }
        });*/


/*        Disposable disposable = Observable.zip(o1, o2, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer o1, Integer o2) throws Exception {

                return o1 + o2;

            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                callback.sss(integer);
            }
        });*/
    }
}

/*            @Override
            public Forecast apply(Forecast f1, Forecast f2) throws Exception {
*//*                ArrayList<Forecast> res = new ArrayList<>();
                res.addAll(Arrays.asList(objects));*//*
                return f1;
            }*/