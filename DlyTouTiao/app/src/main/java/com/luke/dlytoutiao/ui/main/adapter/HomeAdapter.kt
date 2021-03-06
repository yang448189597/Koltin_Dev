package com.luke.dlytoutiao.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeAdapter(fm:FragmentManager,fragments:ArrayList<Fragment>):FragmentPagerAdapter(fm){
    private val fragments:ArrayList<Fragment> = fragments

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]
}