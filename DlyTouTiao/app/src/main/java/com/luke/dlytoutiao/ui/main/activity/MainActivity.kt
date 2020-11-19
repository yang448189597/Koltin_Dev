package com.luke.dlytoutiao.ui.main.activity

import android.util.Log
import androidx.fragment.app.Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.luke.dlytoutiao.R
import com.luke.dlytoutiao.base.BaseActivity
import com.luke.dlytoutiao.ui.main.adapter.HomeAdapter
import com.luke.dlytoutiao.ui.main.fragment.HomeFragment
import com.luke.dlytoutiao.ui.main.fragment.MinVideoFragment
import com.luke.dlytoutiao.ui.main.fragment.MyFragment
import com.luke.dlytoutiao.ui.main.fragment.VideoFragment
import com.luke.dlytoutiao.ui.main.model.TitleModel
import com.luke.dlytoutiao.ui.main.persenter.MainPersenter
import com.luke.dlytoutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPersenter>(), MainView {

    private val titleTabs = ArrayList<CustomTabEntity>()
    private val fragments = ArrayList<Fragment>()

    override fun getLayoutId(): Int = R.layout.activity_main;

    override fun initView() {
        val titles = resources.getStringArray(R.array.title)
        val selectIds = resources.obtainTypedArray(R.array.select)
        val unSelectIds = resources.obtainTypedArray(R.array.unselect)
        for (i: Int in titles.indices) {
            titleTabs.add(
                TitleModel(
                    titles[i],
                    unSelectIds.getResourceId(i,0),
                    selectIds.getResourceId(i, 0)

                )
            )
        }
        fragments.add(HomeFragment())
        fragments.add(MinVideoFragment())
        fragments.add(MyFragment())
        fragments.add(VideoFragment())
        vp_home.adapter = HomeAdapter(supportFragmentManager,fragments)
        // fragments 预加载
        vp_home.offscreenPageLimit = fragments.size
        ctl_home.setTabData(titleTabs)
        ctl_home.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                vp_home.setCurrentItem(position,false)
            }

            override fun onTabReselect(position: Int) {

            }

        })
    }

    override fun initData() {
    }

    override fun createPersenter() = MainPersenter()

    override fun <T> setData(data: T) {
        Log.e("test", "================>$data")
    }

    override fun setError(err: String) {
    }
}