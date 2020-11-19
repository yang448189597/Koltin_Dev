package com.luke.dlytoutiao.ui.main.persenter

import com.luke.dlytoutiao.http.HttpUtils
import com.luke.dlytoutiao.http.ResponseListener
import com.luke.dlytoutiao.http.UserApi
import com.luke.dlytoutiao.mvp.model.BaseModel
import com.luke.dlytoutiao.mvp.persenter.BasePersenter
import com.luke.dlytoutiao.ui.main.model.MainModel
import com.luke.dlytoutiao.ui.main.view.MainView

class MainPersenter : BasePersenter<MainView>() {

    fun getTest(str: String){
//        getBaseView()!!.setData(str)
        HttpUtils.sendHttp(HttpUtils.createApi(UserApi::class.java).getTest(),object :ResponseListener<BaseModel<MainModel>>{
            override fun onSccess(data: BaseModel<MainModel>) {
                if (data!=null){
                    getBaseView()!!.setData(data)
                }
            }

            override fun onFail(string: String) {
                    getBaseView()!!.setError(string)
            }

        })
    }
}

