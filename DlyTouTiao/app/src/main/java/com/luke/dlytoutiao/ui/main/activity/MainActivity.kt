package com.luke.dlytoutiao.ui.main.activity

import android.util.Log
import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseActivity
import com.luke.dlytoutiao.ui.main.persenter.MainPersenter
import com.luke.dlytoutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPersenter>(),MainView {

    override fun getLayoutId(): Int = R.layout.activity_main;

    override fun init() {
        btn_test.setOnClickListener{
            getPersenter()!!.getTest("dly")
        }
    }

    override fun initData() {
    }

    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
       Log.e("test","================>$data")
    }

    override fun setError(err: String) {
    }
}