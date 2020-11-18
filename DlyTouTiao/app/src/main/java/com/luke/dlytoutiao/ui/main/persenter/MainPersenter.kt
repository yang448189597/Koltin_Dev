package com.luke.dlytoutiao.ui.main.persenter

import com.luke.dlytoutiao.mvp.persenter.BasePersenter
import com.luke.dlytoutiao.ui.main.view.MainView

class MainPersenter : BasePersenter<MainView>() {

    fun getTest(str: String){
        getBaseView()!!.setData(str)
    }
}

