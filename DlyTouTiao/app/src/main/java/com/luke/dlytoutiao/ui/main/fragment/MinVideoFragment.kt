package com.luke.dlytoutiao.ui.main.fragment

import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseFragment
import com.luke.dlytoutiao.ui.main.persenter.HomePersenter
import com.luke.dlytoutiao.ui.main.persenter.MinVideoPersenter
import com.luke.dlytoutiao.ui.main.view.HomeView

class MinVideoFragment :BaseFragment<HomeView, MinVideoPersenter>(),HomeView{
    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {
    }

    override fun getLayoutId(): Int = R.layout.min_video_fragment
    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPersenter(): MinVideoPersenter = MinVideoPersenter()

}