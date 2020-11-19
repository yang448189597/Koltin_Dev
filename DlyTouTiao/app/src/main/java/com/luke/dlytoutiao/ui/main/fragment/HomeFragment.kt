package com.luke.dlytoutiao.ui.main.fragment

import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseFragment
import com.luke.dlytoutiao.ui.main.persenter.HomePersenter
import com.luke.dlytoutiao.ui.main.view.HomeView

class HomeFragment :BaseFragment<HomeView, HomePersenter>(), HomeView {
    override fun getLayoutId(): Int = R.layout.home_fragment

    override fun initData() {
    }

    override fun initView() {
    }


    override fun <T> setData(data: T) {
    }

    override fun setError(err: String) {
    }

    override fun createPersenter(): HomePersenter = HomePersenter()

}