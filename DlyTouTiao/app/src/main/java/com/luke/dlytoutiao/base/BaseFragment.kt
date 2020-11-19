package com.luke.dlytoutiao.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.luke.dlytoutiao.mvp.persenter.BasePersenter
import com.luke.dlytoutiao.mvp.view.BaseView

abstract class BaseFragment<V, P : BasePersenter<V>> : Fragment(), BaseView {

    private var mPersenter: P? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mPersenter == null){
            mPersenter = createPersenter()
        }
        mPersenter!!.bindView(this as V)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initData()
    protected abstract fun initView()
    protected abstract fun createPersenter(): P?

    fun getPersenter() = mPersenter

    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }
}