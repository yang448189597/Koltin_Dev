package com.luke.dlytoutiao.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

data class TitleModel(val title:String,val select:Int,var unSelect:Int):CustomTabEntity {
    override fun getTabTitle(): String = title

    override fun getTabSelectedIcon(): Int = select

    override fun getTabUnselectedIcon(): Int = unSelect
}