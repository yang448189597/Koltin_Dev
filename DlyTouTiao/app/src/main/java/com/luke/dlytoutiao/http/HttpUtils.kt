package com.luke.dlytoutiao.http

import com.luke.dlytoutiao.base.Constants.BASE_URL
import com.luke.dlytoutiao.base.Constants.BASE_URL_TEST
import com.orhanobut.logger.Logger
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpUtils {

    // 将HttpUtils 改成一个 Obj ：该类里的方法都是一个静态

    private var mOkhttp: OkHttpClient? =null;

    // 返回一个表达式
    private fun isTest(isTest:Boolean):String = if(isTest) BASE_URL_TEST else BASE_URL

    fun <T> createApi (clazz: Class<T>):T = Retrofit.Builder()
        .baseUrl(isTest(true))
        .client(getClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(clazz)

    private fun getClient():OkHttpClient? {
        if(mOkhttp == null){
            mOkhttp = OkHttpClient.Builder()
                .addInterceptor(getInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(30,TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .build()
        }
        return mOkhttp
    }

    // 拦截器 作用：拦截日志 打印请求的信息（成功或者失败的状态，以及返回的数据）
    private fun getInterceptor() : HttpLoggingInterceptor? {
        HttpLoggingInterceptor.Logger {
            Logger.json(it)
        }
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    //对外的暴露的一个Http方法
    fun <T> sendHttp(ob: Observable<T>, listener:ResponseListener<T>){
        //实现被观察者 都放到主线程中去 更新UI的时候不会报错
        ob.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(object:Observer<T>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: T) {
                    listener!!.onSccess(t)
                }

                override fun onError(e: Throwable) {
                    listener!!.onFail(e.message.toString())
                }

                override fun onComplete() {

                }

            })
    }
}