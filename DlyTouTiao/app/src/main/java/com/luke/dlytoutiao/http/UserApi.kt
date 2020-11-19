package com.luke.dlytoutiao.http

import com.luke.dlytoutiao.mvp.model.BaseModel
import com.luke.dlytoutiao.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {
    //方法写在前,返回的参数写在后面
    // journalismApi
    @GET("journalismApi")
    fun getTest(): Observable<BaseModel<MainModel>>
}