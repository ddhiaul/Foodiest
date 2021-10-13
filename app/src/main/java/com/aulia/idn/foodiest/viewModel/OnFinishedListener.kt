package com.aulia.idn.foodiest.viewModel

interface OnFinishedListener<T> {
    fun success(data: T)
    fun failure(message : String?)
}
