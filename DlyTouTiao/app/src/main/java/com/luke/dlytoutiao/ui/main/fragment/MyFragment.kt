package com.luke.dlytoutiao.ui.main.fragment

import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseFragment
import com.luke.dlytoutiao.ui.main.persenter.MyPersenter
import com.luke.dlytoutiao.ui.main.view.HomeView

class MyFragment :BaseFragment<HomeView,MyPersenter>(),HomeView{
    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }

    override fun getLayoutId(): Int = R.layout.my_fragment
    override fun initData() {

    }

    override fun initView() {

    }

    override fun createPersenter(): MyPersenter = MyPersenter()

}