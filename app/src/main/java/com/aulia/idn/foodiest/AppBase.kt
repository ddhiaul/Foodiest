package com.aulia.idn.foodiest

interface AppBaseInterface<T> {
    fun hideProgressBar()
    fun showData()
    fun showError(message: String?)
}