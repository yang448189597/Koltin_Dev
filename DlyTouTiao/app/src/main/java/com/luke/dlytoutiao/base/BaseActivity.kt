package com.luke.dlytoutiao.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luke.dlytoutiao.mvp.persenter.BasePersenter
import com.luke.dlytoutiao.mvp.view.BaseView

abstract class BaseActivity<V, P : BasePersenter<V>> : AppCompatActivity(), BaseView {

    private var mPersenter: P? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPersenter == null) {
            mPersenter = createPersenter()
        }
        mPersenter!!.bindView(this as V);
        init()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun init()

    protected abstract fun initData()

    protected abstract fun createPersenter(): P

    fun getPersenter() = mPersenter

    override fun onDestroy() {
        super.onDestroy()
        mPersenter!!.unBindView()
    }
}