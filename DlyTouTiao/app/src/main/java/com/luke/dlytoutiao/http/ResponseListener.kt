package com.luke.dlytoutiao.http

interface ResponseListener<T> {
    fun onSccess(data:T)
    fun onFail(string: String)
}