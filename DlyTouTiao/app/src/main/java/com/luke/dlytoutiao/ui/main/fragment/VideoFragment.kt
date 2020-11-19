package com.luke.dlytoutiao.ui.main.fragment

import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseFragment
import com.luke.dlytoutiao.ui.main.persenter.VideoPersenter
import com.luke.dlytoutiao.ui.main.view.HomeView

class VideoFragment :BaseFragment<HomeView,VideoPersenter>(),HomeView{
    override fun <T> setData(data: T) {

    }

    override fun setError(err: String) {

    }

    override fun getLayoutId(): Int = R.layout.video_fragment

    override fun initData() {
    }

    override fun initView() {
    }

    override fun createPersenter(): VideoPersenter = VideoPersenter()

}